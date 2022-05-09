package cg.park.springlotto;

import cg.park.springlotto.jpaModels.user;
import cg.park.springlotto.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class JpaTest {

    @Autowired
    UserRepository userRepository;
    @Test
    public void selectUserEntity() {
        String name = "관리자";
        List<user> users = userRepository.findByName(name);
        System.out.println(users.toString());
    }

    @Test
    public void selectUsers() {
        String name = "관리자";
        List<user> users = userRepository.findByName(name);
        System.out.println(users.toString());
    }
}
