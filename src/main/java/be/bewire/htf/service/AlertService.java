package be.bewire.htf.service;

import be.bewire.htf.entity.Alert;

import java.util.List;

public interface AlertService {

    List<Alert> getAll();

    Alert getById(Integer id);

    Alert save(Alert alert);
}
