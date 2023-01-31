package com.example.SampleApplication;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HelloWorld {
    public String index(){
        return "welcome";
    }
}
