package com.projectK5.pabwe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {


    @RequestMapping("/pages")
    public String home(){
        return "dashboard";
    }

}