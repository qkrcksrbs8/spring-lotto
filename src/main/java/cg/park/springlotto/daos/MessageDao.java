package cg.park.springlotto.daos;

import cg.park.springlotto.models.MessageDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageDao {
    MessageDto selectMessage(String code);
}
