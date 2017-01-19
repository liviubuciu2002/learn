package com.spring_mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/myjsp")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String getIndexPage() {
		System.out.println("====== my out ======");
		return "myview";//, "message", new Object());
	}

}