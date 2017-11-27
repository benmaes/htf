package be.bewire.htf.service;

import be.bewire.htf.entity.Historiek;
import be.bewire.htf.entity.User;
import be.bewire.htf.repository.HistoriekRepository;
import be.bewire.htf.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HistoriekRepository historiekRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getById(final Integer id) {
        return userRepository.findOne(id);
    }

    @Override
    @Transactional
    public User save(final User user) {
        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void addHistoriek(final Historiek historiek) {
        historiekRepository.save(historiek);
    }

    @Override
    public List<Historiek> getHistoriekForUser(final Integer userId) {
        return historiekRepository.findByUserId(userId);
    }
}
