package com222.mybeans;

/**
 * Created by liviu on 2/16/2016.
 */
public class MyBean1 implements CommonBean{
    public static int nrInstances = 0;
    private int value = 2;

    public MyBean1() {
        nrInstances++;
        System.out.println("from myBean1, instances = " + nrInstances);
    }
}
