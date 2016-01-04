package com;


import com.test.A;
import com.test.B;
import com.test.inside.C;
import com.test.inside.big.D.D;
import com.test2.Test2;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MyClass {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
        B b = new B();
        System.out.println("----------------------------------------------------");
        A aa = new A("sdfsd");
        new C();
        new D();
        new Test2();
//        Constructor<A> constructor = A.class.getConstructor(String.class);
//        A a = constructor.newInstance("fsdfsd");

        System.out.println("WWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWWW");
    }
}
