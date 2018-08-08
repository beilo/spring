package com.leipeng.controller;

import com.sun.istack.internal.Nullable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestController extends AbstractController{
    @Nullable
    @Override
    public ModelAndView handleRequestInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        // 获取 Controller 的名称，即地址
        System.out.println(httpServletRequest.getRequestURI());
        // 逻辑名
        return new ModelAndView("index");
    }
}
