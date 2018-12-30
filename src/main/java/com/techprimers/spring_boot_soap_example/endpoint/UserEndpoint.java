/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.techprimers.spring_boot_soap_example.endpoint;

import com.techprimers.spring_boot_soap_example.GetUserRequest;
import com.techprimers.spring_boot_soap_example.GetUserResponse;
import com.techprimers.spring_boot_soap_example.User;
import com.techprimers.spring_boot_soap_example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 *
 * @author eder
 */

@Endpoint
public class UserEndpoint {
    
    @Autowired
    private UserService userService;
    
    @PayloadRoot(namespace = "http://techprimers.com/spring-boot-soap-example", localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        
        GetUserResponse response = new GetUserResponse();
        
        response.setUser(userService.getUser(request.getName()));
        
        return response;
        
        
    }
    
}
