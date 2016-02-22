package com222.mybeans;

/**
 * Created by liviu on 2/16/2016.
 */
public class MyBean2 implements CommonBean{
    public static int nrInstances = 0;
    public int value = 2;

    public MyBean2() {
        nrInstances++;
        System.out.println("from myBean2, instances = " + nrInstances);
    }
}
