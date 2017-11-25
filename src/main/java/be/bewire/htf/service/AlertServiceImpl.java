package be.bewire.htf.service;

import be.bewire.htf.entity.Alert;
import be.bewire.htf.repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlertServiceImpl implements AlertService {

    @Autowired
    private AlertRepository alertRepository;

    @Override
    public List<Alert> getAll() {
        return alertRepository.findAll();
    }

    @Override
    public Alert getById(final Integer id) {
        return alertRepository.findOne(id);
    }

    @Override
    public Alert save(final Alert alert) {
        return alertRepository.save(alert);
    }
}
