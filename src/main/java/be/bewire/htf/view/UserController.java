package be.bewire.htf.view;

import be.bewire.htf.entity.User;
import be.bewire.htf.service.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
