package com.customer.harjoitus.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
    
    @RequestMapping("/")
    @ResponseBody
    public String index() {
        return "Siirry /api sivulle!";
    }

}