package com.example.demo.auth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StaticController implements org.springframework.boot.web.servlet.error.ErrorController {
    @RequestMapping(value = {"/"})
    public String index() {
        return "forward:/index.html";
    }

    @RequestMapping("/error")
    public String handleError() {
        return "forward:/index.html"; // or render a custom error page
    }
}
