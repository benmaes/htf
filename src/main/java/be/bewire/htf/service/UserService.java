package be.bewire.htf.service;

import be.bewire.htf.entity.Historiek;
import be.bewire.htf.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAll();

    User getById(Integer id);

    User save(User user);

    void addHistoriek(Historiek historiek);

    List<Historiek> getHistoriekForUser(Integer userId);
}
