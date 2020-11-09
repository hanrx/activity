package com.iafoot.activity.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/iafoot/test")
public class Test {
    @RequestMapping(value = "/getInfo",method = RequestMethod.GET)
    public String getUserInfo(@RequestParam("id") int id){
        return  "Test iafoot-aaa-getInfo";
    }
}
