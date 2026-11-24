package com.example.loose;
    public class SmsNotificationService implements NotificationService {
        @Override
        public void send(String message) {

            System.out.println("SMS : " + message);
        }
    }

