//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.12 at 09:02:09 PM CEST 
//


package io.github.mufasa1976.springframework.webservice.example.xsd;

import java.time.LocalDateTime;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, LocalDateTime>
{


    public LocalDateTime unmarshal(String value) {
        return (io.github.mufasa1976.springframework.webservice.example.util.LocalDateAdapter.unmarshal(value));
    }

    public String marshal(LocalDateTime value) {
        return (io.github.mufasa1976.springframework.webservice.example.util.LocalDateAdapter.marshal(value));
    }

}