package be.bewire.htf.repository;

import be.bewire.htf.entity.Historiek;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoriekRepository extends JpaRepository<Historiek, Integer> {

    List<Historiek> findByUserId(Integer userId);
}
