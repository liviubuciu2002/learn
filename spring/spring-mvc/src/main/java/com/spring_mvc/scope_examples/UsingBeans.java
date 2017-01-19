package com.spring_mvc.scope_examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Component
@RequestMapping("/scopes")
public class UsingBeans {

    @Autowired
    RequestScopedBean requestScopedBean;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView getMyModel() {

        System.out.println("using bean hashcode:" + toString());
        return new ModelAndView("ModelAndViewExample", "myparameter", requestScopedBean.toString());//, "message", new Object());
    }

}
