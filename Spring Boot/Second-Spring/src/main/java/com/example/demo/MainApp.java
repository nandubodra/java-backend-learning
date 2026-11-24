package com.example.demo;

import com.example.loose.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
    void main(String[] args) {

/*
        ApplicationContext context
                = new ClassPathXmlApplicationContext("applicationBeanContext.xml");

*/
//
//        ApplicationContext context
//                = new AnnotationConfigApplicationContext(AppConfig.class);
//
//        GreetingService greetingService
//                = (GreetingService) context.getBean("myBean");
//        greetingService.sayHello();

//        UserService userServiceSms
//                = (UserService) context.getBean("UserServiceSms");
//        userServiceSms.notifyUser("What's Up!");

//        UserService userServiceEmail
//                = (UserService) context.getBean("UserServiceEmail");
//        userServiceEmail.notifyUser("What's Up!");

//        UserService userServiceEmail
//                =  context.getBean(UserService.class);
//        userServiceEmail.notifyUser("What's Up!");

        System.out.println("Starting Spring Application Context");
          ApplicationContext context
                         = new AnnotationConfigApplicationContext(AppConfig.class);

          System.out.println("Retrieving Lifecycle Bean");
          LifeCycleBean lifeCycleBean
                  = context.getBean(LifeCycleBean.class);

        System.out.println("Closing Spring Context");
    }
}
