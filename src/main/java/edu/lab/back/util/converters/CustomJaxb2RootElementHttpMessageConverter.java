package edu.lab.back.util.converters;

import org.springframework.http.converter.xml.Jaxb2RootElementHttpMessageConverter;

import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

public class CustomJaxb2RootElementHttpMessageConverter extends Jaxb2RootElementHttpMessageConverter {

    @Override
    protected void customizeMarshaller(Marshaller marshaller) {
        try {
            marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
                "<?xml-stylesheet type='text/xsl' href='nameoffile.xsl' ?>");
        } catch (PropertyException e) {
            throw new IllegalStateException(e);
        }
    }

}
