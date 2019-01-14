package com.projectK5.pabwe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/pages/smsgateway")
public class SmsgatewayController {

    @RequestMapping("")
    public String getSmsgateway(){
        return "/pages/smsgateway";
    }
}
