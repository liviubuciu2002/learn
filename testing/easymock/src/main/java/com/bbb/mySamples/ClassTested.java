package com.bbb.mySamples;

/**
 * Created by liviu on 23/05/16.
 */
public class ClassTested {

    public ServiceOne serviceOne;

    public ServiceTwo serviceTwo;

    public void first(){
        System.out.println("first method");
    }

    public void second(){
        System.out.println("second method");
    }

    public void serviceOne_1() {
        serviceOne.service_1();
    }

    public void serviceOne_2() {
        serviceOne.service_2();
    }

    public void serviceTwo_1() {
        serviceTwo.service_1();
    }

    public void serviceTwo_2() {
        serviceTwo.service_2();
    }

}
