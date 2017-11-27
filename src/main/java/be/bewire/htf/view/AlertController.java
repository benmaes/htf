package be.bewire.htf.view;

import be.bewire.htf.entity.Alert;
import be.bewire.htf.entity.User;
import be.bewire.htf.notification.Notification;
import be.bewire.htf.service.AlertService;
import be.bewire.htf.service.NotificationService;
import be.bewire.htf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.List;

@Controller
public class AlertController {

    @Autowired
    private AlertService alertService;

    @Autowired
    private UserService userService;

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/alert")
    public String alert() {
        return "alert";
    }

    @PostMapping("/alert")
    public String handleFileUpload(
        @RequestParam("message")
        String message,
        @RequestParam("file")
            MultipartFile file,
        @RequestParam("latitude")
            Double latitude,
        @RequestParam("longitude")
            Double longitude, RedirectAttributes redirectAttributes)
        throws IOException {

        Alert alert = new Alert();
        alert.setMessage(message);
        alert.setLatitude(latitude);
        alert.setLongitude(longitude);
        alert.setImage(file.getBytes());

        User user = (User) SecurityContextHolder.getContext()
            .getAuthentication().getPrincipal();
        alert.setUserId(user.getId());
        user.setLastLatitude(latitude);
        user.setLastLongitude(longitude);

        userService.save(user);
        alert = alertService.save(alert);

        redirectAttributes.addFlashAttribute("message",
            "You successfully uploaded " + file.getOriginalFilename() + "!");

        notificationService.notify(
            new Notification(String.format("New alert [%s]: %s", alert.getId(), alert.getMessage())),
            user.getUsername());

        return "redirect:/home";
    }

    @GetMapping("/alert/{id}")
    public String getAlertById(
        @PathVariable("id")
            int id, Model model) {
        Alert alert = alertService.getById(id);

        BASE64Encoder base64Encoder = new BASE64Encoder();
        StringBuilder imageString = new StringBuilder();
        imageString.append("data:image/png;base64,");
        imageString.append(base64Encoder.encode(alert.getImage()));
        String image = imageString.toString();
        model.addAttribute("image", image);
        model.addAttribute("alert", alert);
        return "alertDetail";
    }

    @GetMapping("/alerts")
    public String getAllAlerts(Model model) {
        List<Alert> alerts = alertService.getAll();
        model.addAttribute("alerts", alerts);
        return "alerts";
    }
}
