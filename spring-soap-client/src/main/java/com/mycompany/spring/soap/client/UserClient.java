/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.spring.soap.client;


import domain.GetUserRequest;
import domain.GetUserResponse;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class UserClient extends WebServiceGatewaySupport {

    public GetUserResponse getClient(String name) {

        GetUserRequest request = new GetUserRequest();
        request.setName(name);

        GetUserResponse response = (GetUserResponse) getWebServiceTemplate()
                .marshalSendAndReceive("http:http://localhost:8095/soapWS/users", request,
                        new SoapActionCallback("http://soap.spring.mycompany.com/GetUserRequest"));

        return response;
    }

}
