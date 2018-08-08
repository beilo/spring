package com.leipeng.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CeshiController {

    @RequestMapping("/ceshi") // 请求映射到 http://localhost:8954/springmvcannotation/ceshi.action
    public String goCeshi(HttpServletRequest request){
        System.out.println(request.getRequestURL());
        return "index";
    }
}
