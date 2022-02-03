package com.shaoli.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/alpha")
public class Alphacontroller {
    @RequestMapping("/hello")
    @ResponseBody
    public String sayhello(){
        return "Hello shaoli.";
    }
}
