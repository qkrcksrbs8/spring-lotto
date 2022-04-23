package cg.park.springlotto.daos;

import cg.park.springlotto.models.HistoryCountDto;
import cg.park.springlotto.utils.Param;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface HistoryDao {
    int historyCount(int number);
    int updateHistoryCount(HashMap<String, Integer> map);
    HistoryCountDto selectHistoryCount();
    Param thisWeek();
}
