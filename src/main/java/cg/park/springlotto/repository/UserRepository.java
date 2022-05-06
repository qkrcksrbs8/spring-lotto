package cg.park.springlotto.repository;

import cg.park.springlotto.jpaModels.user;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<user, Long> {
    List<user> findByName(String name);
}
