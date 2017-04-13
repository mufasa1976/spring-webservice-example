package io.github.mufasa1976.springframework.webservice.example;

import lombok.val;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.ws.wsdl.wsdl11.Wsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@Configuration
@EnableWs
public class WebServiceConfig {

  @Bean
  public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
    MessageDispatcherServlet servlet = new MessageDispatcherServlet();
    servlet.setApplicationContext(applicationContext);
    servlet.setTransformWsdlLocations(true);
    return new ServletRegistrationBean(servlet, "/ws/*");
  }

  @Bean(name = "helloWorld")
  public Wsdl11Definition helloWorldWsdl(XsdSchema helloWorldSchema) {
    DefaultWsdl11Definition wsdl = new DefaultWsdl11Definition();
    wsdl.setPortTypeName("HelloWorldPort");
    wsdl.setLocationUri("/ws");
    wsdl.setTargetNamespace("http://mufasa1976.github.io/webservice/helloWorld");
    wsdl.setSchema(helloWorldSchema);
    return wsdl;
  }

  @Bean
  public XsdSchema helloWorldSchema() {
    return new SimpleXsdSchema(new ClassPathResource("xsd/helloWorld.xsd"));
  }
}
