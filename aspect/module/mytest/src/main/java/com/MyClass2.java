package com;

import com.test.A;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Created by liviubu on 12/10/15.
 */
public class MyClass2 {
    public static void main(String[] args) throws UnknownHostException {
        A a  = new A("as");

        System.out.println(a.getClass().getClassLoader().getClass().getName());
        ClassLoader parent = a.getClass().getClassLoader().getParent();
        while (parent != null) {
            System.out.println(parent.getClass().getName());
            parent = parent.getParent();
        }
    }
}
