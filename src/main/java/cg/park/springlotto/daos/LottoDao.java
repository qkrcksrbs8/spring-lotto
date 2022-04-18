package cg.park.springlotto.daos;
import cg.park.springlotto.models.UserLottoHistoryVo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LottoDao {
    int insertUserLottoHistory(UserLottoHistoryVo userLottoHistory);
}
