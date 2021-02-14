package com.homework_lesson_13.parser.sax;

import com.homework_lesson_13.model.customer.Customer;
import com.homework_lesson_13.parser.I_Parser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SAX_parser implements I_Parser {

    @Override
    public List<Customer> parse(String place) {
        List<Customer> customerList = new ArrayList<>();

        try{
            File input = new File(place);
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            CustomerHandler handler = new CustomerHandler();
            saxParser.parse(input, handler);

            customerList = handler.getCustomerList();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
