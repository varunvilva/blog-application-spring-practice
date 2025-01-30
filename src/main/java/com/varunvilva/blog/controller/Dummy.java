package com.varunvilva.blog.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Dummy {

    @GetMapping("/admin/")
    public String adminTest(){
        return "You are admin";
    }
    @GetMapping("/user/")
    public String userTest(){
        return "You are user";
    }
}
