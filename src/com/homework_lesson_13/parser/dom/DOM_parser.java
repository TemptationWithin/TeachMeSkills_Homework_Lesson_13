package com.homework_lesson_13.parser.dom;

import com.homework_lesson_13.model.customer.Customer;
import com.homework_lesson_13.parser.I_Parser;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOM_parser implements I_Parser {

    @Override
    public List<Customer> parse(String place){
        ArrayList<Customer> list = new ArrayList<>();
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db;
        Document document = null;
        {
            try {
                db = dbf.newDocumentBuilder();
                document = db.parse(new File(place));
                document.getDocumentElement().normalize();
            } catch (ParserConfigurationException e) {
                e.printStackTrace();
            } catch (SAXException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        NodeList customers = document.getElementsByTagName("customer");
        for (int i = 0; i < customers.getLength(); i++) {
            Node customer = customers.item(i);
            if (customer.getNodeType() == Node.ELEMENT_NODE){
                Element element = (Element) customer;
                String name = element.getAttribute("name");
                String ip = element.getAttribute("ip");
                Integer age = Integer.parseInt(element.getAttribute("age"));
                list.add(new Customer(name,ip,age));
            }

        }
            return list;
    }
    
}
