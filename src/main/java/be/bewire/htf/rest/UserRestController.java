package be.bewire.htf.rest;

import be.bewire.htf.entity.User;
import be.bewire.htf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserRestController {

    @Autowired
    private UserService userService;

//    @GetMapping("/users")
//    public List<User> getAll() {
//        return userService.getAll();
//    }
//
//    @GetMapping("/users/{name}")
//    public User getByName(@PathVariable("name") String name) {
//        return userService.getByName(name);
//    }
}
