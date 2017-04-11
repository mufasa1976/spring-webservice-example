package io.github.mufasa1976.springframework.webservice.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.WebServiceMessageReceiverHandlerAdapter;

@Configuration
@EnableWs
public class WebServiceConfig {

  @Bean
  public HandlerAdapter webServiceMessageReceiverHandlerAdapter() {
    return new WebServiceMessageReceiverHandlerAdapter();
  }

  @Bean
  public HandlerAdapter requestMappingHandlerAdapter() {
    return new RequestMappingHandlerAdapter();
  }
}
