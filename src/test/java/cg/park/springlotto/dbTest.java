package cg.park.springlotto;

import cg.park.springlotto.daos.LottoDao;
import cg.park.springlotto.models.LottoNumberVo;
import cg.park.springlotto.models.MessageVo;
import cg.park.springlotto.models.UserLottoHistoryVo;
import cg.park.springlotto.services.impl.LottoServiceImpl;
import cg.park.springlotto.utils.LottoHistoryUtil;
import cg.park.springlotto.utils.MessageUtil;
import cg.park.springlotto.utils.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
public class dbTest {

    @Autowired
    LottoDao lottoDao;

    @Autowired
    LottoServiceImpl lottoServiceimpl;

    @Autowired
    LottoHistoryUtil lottoHistoryUtil;

    // 단일 로또 번호 출력 저장 테스트
    @Test
    public void insertUserLottoHistoryTest() {
        System.out.println("insertUserLottoHistoryTest");

        try {
//            UserLottoHistory userLottoHistory =
//                    UserLottoHistory.builder()
//                                    .groupNo(1)
//                                    .memberNo(1)
//                                    .memberFlag("0")
//                                    .firstNo(1)
//                                    .secondNo(1)
//                                    .thirdNo(1)
//                                    .forthNo(1)
//                                    .fifthNo(1)
//                                    .round(1)
//                                    .createdUser("admin")
//                                    .updateUser("admin");
            MessageVo result = lottoServiceimpl.execute(new Param().set("count", 1));
            UserLottoHistoryVo userLottoHistory = new UserLottoHistoryVo();
            userLottoHistory.setMemberNo(1);
            userLottoHistory.setMemberFlag("1");
            userLottoHistory.setRound(1);
            userLottoHistory.setCreatedUser("admin");
            userLottoHistory.setUpdateUser("admin");
            userLottoHistory.setLottoNumbers(lottoHistoryUtil.saveMessageHistory(result));
            lottoDao.insertUserLottoHistory(userLottoHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // 다중 로또 번호 출력 저장 테스트
    @Test
    public void insertUserLottoHistorysTest() {
        System.out.println("insertUserLottoHistoryTest");

        try {
            MessageVo result = lottoServiceimpl.execute(new Param().set("count", 5));
            UserLottoHistoryVo userLottoHistory = new UserLottoHistoryVo();
            userLottoHistory.setMemberNo(1);
            userLottoHistory.setMemberFlag("1");
            userLottoHistory.setRound(1);
            userLottoHistory.setCreatedUser("admin");
            userLottoHistory.setUpdateUser("admin");
            userLottoHistory.setLottoNumbers(lottoHistoryUtil.saveMessageHistory(result));
            lottoDao.insertUserLottoHistory(userLottoHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
