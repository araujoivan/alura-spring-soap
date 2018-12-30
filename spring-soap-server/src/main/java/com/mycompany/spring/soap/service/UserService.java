/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.soap.service;

import com.mycompany.spring.soap.domain.User;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

/**
 *
 * @author eder
 */
@Service
public class UserService {
    
    private Map<String, User> usersMap = new HashMap();
    
    @PostConstruct
    private void initialize() {
        
        User peter = new User();
        
        peter.setName("Peter");
        peter.setEmpId(1);
        peter.setSalary(1000);
        
        User ryan = new User();
        
        ryan.setName("Ryan");
        ryan.setEmpId(2);
        ryan.setSalary(2000);
        
        User sam = new User();
        
        sam.setName("Sam");
        sam.setEmpId(3);
        sam.setSalary(3000);
        
        usersMap.put(peter.getName(), peter);
        usersMap.put(sam.getName(), sam);
        usersMap.put(ryan.getName(), ryan);      
    }
    
    public User getUser(String name) {
        return usersMap.get(name);
    }
    
}
