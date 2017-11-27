package be.bewire.htf.view;

import be.bewire.htf.entity.Historiek;
import be.bewire.htf.entity.User;
import be.bewire.htf.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public String user(Model model) {
        List<User> users = userService.getAll();
        model.addAttribute("users", users);

        Gson gson = new GsonBuilder().create();
        JsonArray jsonArray = gson.toJsonTree(users, List.class).getAsJsonArray();
        model.addAttribute("list", jsonArray);

        return "users";
    }

    @GetMapping("/user/update")
    public String updateLocation(@RequestParam("latitude") Double latitude,
        @RequestParam("longitude") Double longitude, Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Historiek historiek = new Historiek();
        historiek.setUserId(user.getId());
        historiek.setLatitude(latitude);
        historiek.setLongitude(longitude);
        historiek.setDate(new Date());
        userService.addHistoriek(historiek);

        user.setLastLatitude(latitude);
        user.setLastLongitude(longitude);
        user = userService.save(user);

        model.addAttribute("name", user.getName());

        return "home";
    }

    @GetMapping("/user/{id}")
    public String updateLocation(@PathVariable("id") Integer id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);

        List<Historiek> historiekForUser = userService
            .getHistoriekForUser(user.getId());
        model.addAttribute("historiek", historiekForUser);

        return "userDetail";
    }
}
