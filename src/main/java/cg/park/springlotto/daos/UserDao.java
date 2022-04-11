package cg.park.springlotto.daos;

import cg.park.springlotto.models.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> allUser();
}
