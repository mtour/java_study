package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/hello", method = RequestMethod.GET)
public class HomeController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String printHello(Model model) {

        return "index";
    }


}