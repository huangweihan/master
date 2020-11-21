package com.han.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HeyController {

    @RequestMapping("/hey")
    @ResponseBody
    public String hell(){
        return "hello world";
    }
}
