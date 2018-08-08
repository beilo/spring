package com.leipeng.controller;

import com.leipeng.pojo.Person;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class PersonFormController extends SimpleFormController {
    public PersonFormController() {
        this.setCommandClass(Person.class);
    }

    protected void duSubmitAction(Object command) throws Exception{
        Person person = (Person) command;
        System.out.println(person);
    }
}
