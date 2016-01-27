package com.test;

public class B extends A {
    public B() {
        super("contructParam");
        int i = 2;
        System.out.println("from constructor B; i = " + i);
    }
}
