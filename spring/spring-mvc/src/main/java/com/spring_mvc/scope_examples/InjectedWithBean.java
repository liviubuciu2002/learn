package com.spring_mvc.scope_examples;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InjectedWithBean {

    @Autowired
    private RequestScopedBean requestScopedBean;

    public int getHashcode() {
        return requestScopedBean.hashCode();
    }

}
