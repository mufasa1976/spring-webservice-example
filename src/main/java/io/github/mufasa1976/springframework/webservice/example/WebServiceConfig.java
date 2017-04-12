package io.github.mufasa1976.springframework.webservice.example;

import lombok.val;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.server.MessageDispatcher;
import org.springframework.ws.soap.server.SoapMessageDispatcher;
import org.springframework.ws.transport.http.WebServiceMessageReceiverHandlerAdapter;
import org.springframework.ws.transport.http.WsdlDefinitionHandlerAdapter;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;

import java.util.List;
import java.util.Properties;

@Configuration
@EnableWs
public class WebServiceConfig {

  @Bean
  public HandlerAdapter webServiceMessageReceiverHandlerAdapter() {
    val handlerAdapter = new WebServiceMessageReceiverHandlerAdapter();
    return handlerAdapter;
  }

  @Bean
  public HandlerAdapter wsdlDefinitionHandlerAdapter() {
    val handlerAdapter = new WsdlDefinitionHandlerAdapter();
    handlerAdapter.setTransformLocations(true);
    handlerAdapter.setTransformSchemaLocations(true);
    return handlerAdapter;
  }

  @Bean
  public HandlerAdapter requestMappingHandlerAdapter() {
    return new RequestMappingHandlerAdapter();
  }

  @Bean
  public MessageDispatcher soapMessageDispatcher(ApplicationContext applicationContext) {
    val soapMessageDispatcher = new SoapMessageDispatcher();
    soapMessageDispatcher.setApplicationContext(applicationContext);
    return soapMessageDispatcher;
  }

  @Bean
  public HandlerMapping handlerMapping(MessageDispatcher messageDispatcher, List<Wsdl11Definition> wsdl11Definitions) {
    val handlerMapping = new SimpleUrlHandlerMapping();
    val mappings = new Properties();
    wsdl11Definitions.stream()
        .forEach(wsdl11Definition -> mappings.setProperty(wsdl11Definition.getSource().getSystemId(), wsdl11Definition));
    handlerMapping.setMappings(mappings);
    handlerMapping.setDefaultHandler(messageDispatcher);
    return handlerMapping;
  }

  @Bean
  public Wsdl11Definition bookServiceWsdl() {
    val wsdlDefinition = new DefaultWsdl11Definition();
    return wsdlDefinition;
  }
}
