package cg.park.springlotto.daos;

import cg.park.springlotto.models.MessageVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageDao {
    MessageVo selectMessage(String code);
}
