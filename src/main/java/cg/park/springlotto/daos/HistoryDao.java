package cg.park.springlotto.daos;

import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;

@Mapper
public interface HistoryDao {
    int historyCount(int number);
    int updateHistoryCount(HashMap<String, Integer> map);
}
