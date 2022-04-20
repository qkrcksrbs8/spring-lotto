package cg.park.springlotto.daos;
import cg.park.springlotto.models.UserLottoHistoryDto;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LottoDao {
    int saveUserLottoHistory(UserLottoHistoryDto userLottoHistory);
}
