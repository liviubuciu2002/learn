package com.example.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    @ConditionalOnProperty(name = "notification_type", havingValue = "email" , matchIfMissing = true)
    public NotificationService emailNotificationService() {
        return new EmailNotificationService();
    }

    @Bean
    @ConditionalOnProperty(name = "notification_type", havingValue = "sms")
    public NotificationService smsNotificationService() {
        System.out.println("liviu from config ");
        return new SmsNotificationService();
    }
}