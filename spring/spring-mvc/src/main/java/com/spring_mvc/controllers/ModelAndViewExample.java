package com.spring_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/modelandview")
public class ModelAndViewExample {

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMyModel() {
        System.out.println("======" + ModelAndViewExample.class.toString()+ "======");
        return new ModelAndView("ModelAndViewExample", "myparameter", "myValue");//, "message", new Object());
    }

}