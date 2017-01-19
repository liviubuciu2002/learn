package com.spring_mvc.scope_examples;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(value = "request")
public class RequestScopedBean_2 {
}
