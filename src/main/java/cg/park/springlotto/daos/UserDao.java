package cg.park.springlotto.daos;

import cg.park.springlotto.models.UserDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<UserDto> allUser();
}
