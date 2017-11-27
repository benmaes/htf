package be.bewire.htf.service;

import be.bewire.htf.notification.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @Override
    public void notify(final Notification notification, final String username) {
        messagingTemplate.convertAndSendToUser(username, "/queue/notify", notification);
    }
}
