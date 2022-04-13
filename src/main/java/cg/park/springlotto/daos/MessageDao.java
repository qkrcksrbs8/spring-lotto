package cg.park.springlotto.daos;

import cg.park.springlotto.models.Message;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MessageDao {
    Message selectMessage(String code);
}
