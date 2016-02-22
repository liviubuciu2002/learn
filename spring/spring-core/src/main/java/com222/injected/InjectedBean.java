package com222.injected;

import com222.mybeans.CommonBean;
import com222.mybeans.MyBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * Created by liviu on 2/16/2016.
 */
public class InjectedBean {

    @Value("#{ false ? @myBean1 : @myBean2}")
    public CommonBean myBean1;

    public String myString;

    public String testBean() {
        return "fromInjectedBean ==  " + myBean1.getClass().getName();
    }

    public CommonBean getMyBean1() {
        return myBean1;
    }

    public void setMyBean1(CommonBean myBean1) {
        this.myBean1 = myBean1;
    }

    public String getMyString() {
        return myString;
    }

    public void setMyString(String myString) {
        this.myString = myString;
    }
}
