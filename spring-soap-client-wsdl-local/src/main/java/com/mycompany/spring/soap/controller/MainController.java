/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.soap.controller;

import com.mycompany.spring.soap.client.UserClient;
import com.mycompany.spring.soap.domain.GetUserResponse;
import com.mycompany.spring.soap.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eder
 */
@RestController
public class MainController {
    
    @Autowired
    private UserClient userClient;
      
    //Ex: GET to http://localhost:8096/get-user/Sam
    @GetMapping("/get-user/{name}")
    public User gerUser(@PathVariable String name) {
        
        final GetUserResponse response = userClient.getClient(name);
        
        return response.getUser();
    }  
}
