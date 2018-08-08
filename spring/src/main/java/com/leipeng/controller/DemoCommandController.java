package com.leipeng.controller;

import com.leipeng.pojo.Person;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoCommandController extends org.springframework.web.servlet.mvc.AbstractCommandController{
    public DemoCommandController() {
        super(Person.class);
    }

    @Override
    protected ModelAndView handle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, BindException e) throws Exception {
        Person person = (Person) o;
        System.out.println(person);
        return null;
    }
}
