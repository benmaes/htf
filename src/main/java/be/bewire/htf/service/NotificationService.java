package be.bewire.htf.service;

import be.bewire.htf.notification.Notification;

public interface NotificationService {

    void notify(Notification notification, String username);
}
