package be.bewire.htf.service;

import be.bewire.htf.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getByName(String name);

    User save(User user);
}
