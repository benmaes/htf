package be.bewire.htf.view;

import be.bewire.htf.entity.User;
import be.bewire.htf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("/")
    public String hello() {
        return "hello";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/logout")
    public String logout() {
        return "logout";
    }

    @RequestMapping("/register")
    public String register(Model model) {
        model.addAttribute("registration", new Registration());
        return "register";
    }

    @RequestMapping("/home")
    public String hello(Model model) {
        model.addAttribute("name", ((User)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getName());
        return "home";
    }

    @PostMapping("/register")
    private String newUser(@ModelAttribute Registration registration, RedirectAttributes redirectAttributes) {
        User user = new User();
        user.setName(registration.getName());
        user.setUsername(registration.getUsername());
        user.setPassword(registration.getPassword());

        user = userService.save(user);

        redirectAttributes.addFlashAttribute("message",
            "Registration of user " + user.getName() + " successful");
        return "redirect:/login";
    }
}
