package com.trustrace.SpringDemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    
    @GetMapping("/")
    String hello1() {
        return "Hello 1";
    }

    @GetMapping(value = {"/hello", "/hello/{id}"})
    String hello2(@PathVariable(required = false) String id) {
        return "Hello " + id;
    }

    @PostMapping("/detail")
    String getDeatil(@RequestBody String detail) {
        return "Sent deatils " + detail;
    }
}
