package com222;

import com222.beans_scaned.MyBean3;
import com222.injected.InjectedBean;
import com222.mybeans.MyBean1;
import com222.mybeans.MyBean2;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by liviu on 2/16/2016.
 */
public class MyStarter {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");

        MyBean1 myBean = (MyBean1) context.getBean("myBean1");
        System.out.println(myBean.hashCode());

        MyBean2 myBean2 = (MyBean2) context.getBean("myBean2");
        InjectedBean injectedBean = (InjectedBean) context.getBean("injected");
        System.out.println("+++++" + injectedBean.testBean());

        MyBean3 myBean3 = (MyBean3) context.getBean("myBean3_Component");
        System.out.println("+++++" + myBean3.toString());
    }
}
