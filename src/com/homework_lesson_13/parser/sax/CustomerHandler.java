package com.homework_lesson_13.parser.sax;

import com.homework_lesson_13.model.customer.Customer;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class CustomerHandler extends DefaultHandler {
    private List<Customer> customerList = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if(qName.equals("customer")) {
            String name = attributes.getValue("name");
            String ip = attributes.getValue("ip");
            int age = Integer.parseInt(attributes.getValue("age"));
            customerList.add(new Customer(name, ip, age));
        }
    }

    @Override
    public void startDocument() throws SAXException {
        System.out.println("Обработка начата.");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("Обработка завершена.");
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
