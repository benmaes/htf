package be.bewire.htf.repository;

import be.bewire.htf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByNameLike(String name);
}
