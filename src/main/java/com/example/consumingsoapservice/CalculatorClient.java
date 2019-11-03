package com.example.consumingsoapservice;

import com.example.consumingwebservice.wsdl.Add;
import com.example.consumingwebservice.wsdl.AddResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

public class CalculatorClient extends WebServiceGatewaySupport {
    private static final Logger log = LoggerFactory.getLogger(CalculatorClient.class);

    public AddResponse sum(int augend, int adden) {
        Add addRequest = new Add();
        addRequest.setIntA(augend);
        addRequest.setIntB(adden);

        log.info("Requesting add {} and {}", augend, adden);
        AddResponse response = (AddResponse) getWebServiceTemplate()
                .marshalSendAndReceive(
                        "http://www.dneonline.com/calculator.asmx",
                        addRequest,
                        new SoapActionCallback("http://tempuri.org/Add")
                );

        log.info("answer is {}", response.getAddResult());
        return response;
    }


}
