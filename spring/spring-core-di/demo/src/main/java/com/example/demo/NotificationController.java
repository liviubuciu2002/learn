package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        System.out.println("liviu from controller, constructor");
        System.out.println(notificationService);
        this.notificationService = notificationService;
    }

    public void send(String message) {
        notificationService.sendNotification(message);
    }
}