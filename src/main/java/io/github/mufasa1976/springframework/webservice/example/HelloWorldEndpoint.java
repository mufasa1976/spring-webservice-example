package io.github.mufasa1976.springframework.webservice.example;

import io.github.mufasa1976.springframework.webservice.example.xsd.HelloWorldRequest;
import io.github.mufasa1976.springframework.webservice.example.xsd.HelloWorldResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.math.BigInteger;

@Endpoint
@Slf4j
public class HelloWorldEndpoint {

  private final static String NAMESPACE_URI = "http://mufasa1976.github.io/webservice/helloWorld";

  @PayloadRoot(localPart = "HelloWorldRequest", namespace = NAMESPACE_URI)
  @ResponsePayload
  public HelloWorldResponse helloWorld(@RequestPayload HelloWorldRequest request) {
    log.info("Name: " + request.getName());
    log.info("Birthdate: " + request.getBirthdate());
    log.info("Sex: " + request.getSex());
    HelloWorldResponse response = new HelloWorldResponse();
    response.setId(BigInteger.TEN);
    return response;
  }

}
