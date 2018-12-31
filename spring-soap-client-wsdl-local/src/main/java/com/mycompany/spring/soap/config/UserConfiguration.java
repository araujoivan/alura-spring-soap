/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.soap.config;

import com.mycompany.spring.soap.client.UserClient;
import com.mycompany.spring.soap.domain.ObjectFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

@Configuration
public class UserConfiguration {
    
    @Value("${app.ws.default-url}")
    private String defaultWSUri;

    // When declaring other beans for different services, is necessary an explicity name for marshaller method
    // Ex:  public Jaxb2Marshaller clientMarshaller()
    @Bean
    public Jaxb2Marshaller marshaller() {
        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        
        marshaller.setPackagesToScan(getDomainClassesPackage());
        
        return marshaller;
    }

    // When declaring other beans for different services, is necessary an explicity name for marshaller parameter
    // ex: public UserClient userClient(Jaxb2Marshaller clientMarshaller)
    @Bean
    public UserClient userClient(Jaxb2Marshaller marshaller) {
        final UserClient client = new UserClient();
        
        client.setDefaultUri(defaultWSUri);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        
        return client;
    }
    
    private String getDomainClassesPackage() {
        final String canonicalName = ObjectFactory.class.getCanonicalName();
        return canonicalName.substring(0, canonicalName.lastIndexOf("."));
    }

}
