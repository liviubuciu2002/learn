package com.spring_mvc.scope_examples;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class RequestScopedBean {

    @Autowired
    RequestScopedBean_2 requestScopedBean_2;

    @PostConstruct
    public void init() {
        System.out.println("start request");
    }

    @PreDestroy
    public void onDestroy() {
        System.out.println("ends request");
    }
}