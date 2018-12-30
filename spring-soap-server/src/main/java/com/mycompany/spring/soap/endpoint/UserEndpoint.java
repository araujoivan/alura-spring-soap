/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.soap.endpoint;


import com.mycompany.spring.soap.domain.GetUserRequest;
import com.mycompany.spring.soap.domain.GetUserResponse;
import com.mycompany.spring.soap.service.UserService;
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
    
    @PayloadRoot(namespace = "http://soap.spring.mycompany.com/domain", localPart = "getUserRequest")
    @ResponsePayload
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request) {
        
        GetUserResponse response = new GetUserResponse();
        
        response.setUser(userService.getUser(request.getName()));
        
        return response;
        
        
    }
    
}
