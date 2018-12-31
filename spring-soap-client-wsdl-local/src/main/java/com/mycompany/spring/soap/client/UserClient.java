/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.soap.client;

import com.mycompany.spring.soap.domain.GetUserRequest;
import com.mycompany.spring.soap.domain.GetUserResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UserClient extends WebServiceGatewaySupport {

    @Value("${app.ws.default-url}")
    private String defaultWSUri;

    public GetUserResponse getClient(String name) {

        final GetUserRequest request = new GetUserRequest();

        request.setName(name);

        final GetUserResponse response = (GetUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive(defaultWSUri.concat("/users"), request,
                        new SoapActionCallback("http://soap.spring.mycompany.com/GetUserRequest"));

        return response;
    }

}
