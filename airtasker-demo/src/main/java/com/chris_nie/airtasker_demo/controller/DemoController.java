package com.chris_nie.airtasker_demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequestMapping("")
public class DemoController {

    @Value("${airtasker-demo.app.name}")
    private String appName;

    @GetMapping("/")
    public String app() {
        return appName;
    }

    @GetMapping("/_health")
    public String health() {
        return "OK";
    }
}
