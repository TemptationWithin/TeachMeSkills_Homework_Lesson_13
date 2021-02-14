package com.homework_lesson_13;

import com.homework_lesson_13.model.customer.Customer;
import com.homework_lesson_13.parser.dom.DOM_parser;
import com.homework_lesson_13.parser.sax.SAX_parser;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. Создать самостоятельно xml-документа с данными customer'ов.
 * Пусть для каждого кастомера будет 2-3 атрибута
 * 2. Написать SAX парсер, который будет выводить на консоль данные кастомера,
 * а так же выводить на консоль сообщение(любое), когда началась обработка документа и когда завершилась обработка документа
 * 3. Написать DOM парсер для вывода на консоль всех данных кастомера
 * 4. Пусть оба этих парсера наследуются от одного интерфейса.
 * Пусть у интерфейса будет один метод и классы-парсеры реализуют его
 * Задание со звездочкой:
 * 1. сделать запись джава-объекта в xml и обратно с помощью JAXB
 * 2. сделать запись джава-объекта в json и обратно с помощью библиотеки jackson
 */
public class Main {
    public static void main(String[] args) {

        DOM_parser dom_parser = new DOM_parser();

        System.out.println("DOM: ");

        List<Customer> list1 = dom_parser.parse("c:\\Users\\kren_\\IdeaProjects\\" +
                                               "HomeWork_Lesson_13\\Customers.xml");

        list1.stream().forEach((customer -> System.out.println("Customer: Name: " + customer.getName() +
                                                            ", age: " + customer.getAge() +
                                                            ", IP: " + customer.getIp())));

        System.out.println(" ");
        System.out.println("SAX: ");

        SAX_parser saxParser = new SAX_parser();

        List<Customer> list2 = saxParser.parse("c:\\Users\\kren_\\IdeaProjects\\" +
                "HomeWork_Lesson_13\\Customers.xml");

        list2.stream().forEach((customer -> System.out.println("Customer: Name: " + customer.getName() +
                ", age: " + customer.getAge() +
                ", IP: " + customer.getIp())));

        List<Customer> list3 = new ArrayList<>();
        list3.add(new Customer("Leonid", "100.104.35.2.5", 40));
        list3.add(new Customer("Sew", "100.153.23.27.8", 40));
        list3.add(new Customer("Leonardo", "100.176.88.13.9", 40));
        list3.add(new Customer("Carol", "100.52.75.5.0", 40));
        list3.add(new Customer("Clare", "100.185.69.2.1", 40));
    }
}
