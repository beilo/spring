package com.leipeng.controller;

import com.leipeng.pojo.Person;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DemoWizardController extends AbstractWizardFormController {

    public DemoWizardController() {
        // 页面数据封装到command对象,对应实体类为Person
        this.setCommandClass(Person.class);
        // 帮助页面实现回显功能
        this.setCommandName("p");
    }

    // 最终完成后提交
    @Override
    protected ModelAndView processFinish(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object command, BindException e) throws Exception {
        Person person  = (Person) command;
        System.out.println(person);
        return new ModelAndView("index");
    }

    // 取消填写,返回第一个页面
    @Override
    protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView("wizard/PersonInfo");
    }
}
