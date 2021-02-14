package com.homework_lesson_13.parser;

import com.homework_lesson_13.model.customer.Customer;

import java.util.List;

public interface I_Parser {

    List<Customer> parse (String place);
}
