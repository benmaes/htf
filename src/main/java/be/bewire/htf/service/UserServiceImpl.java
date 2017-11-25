package be.bewire.htf.service;

import be.bewire.htf.entity.User;
import be.bewire.htf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getByName(final String name) {
        return userRepository.findByNameLike(name);
    }

    @Override
    public User save(final User user) {
        return userRepository.save(user);
    }
}
