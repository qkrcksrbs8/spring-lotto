package cg.park.springlotto;

import cg.park.springlotto.daos.LottoDao;
import cg.park.springlotto.models.MessageVo;
import cg.park.springlotto.models.UserLottoHistoryVo;
import cg.park.springlotto.services.impl.LottoServiceImpl;
import cg.park.springlotto.utils.LottoHistoryUtil;
import cg.park.springlotto.utils.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
            userLottoHistory.setLottoNumbers(lottoHistoryUtil.setLottoNumbers(result));
            lottoDao.saveUserLottoHistory(userLottoHistory);
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
            userLottoHistory.setLottoNumbers(lottoHistoryUtil.setLottoNumbers(result));
            lottoDao.saveUserLottoHistory(userLottoHistory);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Autowired
    LottoHistoryUtil historyUtil;

    // 단일 로또 API 테스트
    @Test
    public void singleLottoTest() {
        System.out.println("singleLottoTest");
        MessageVo messageVo = historyUtil.resProxy(lottoServiceimpl.execute(new Param().set("count", 1)));
        System.out.println("end");
    }

    // 다중 로또 API 테스트
    @Test
    public void MultiLottoTest() {
        System.out.println("MultiLottoTest");
        MessageVo messageVo = historyUtil.resProxy(lottoServiceimpl.execute(new Param().set("count", 5)));
        System.out.println("end");
    }

    // 다중 로또 API 오류 테스트
    @Test
    public void MultiLottoErrorTest() {
        System.out.println("MultiLottoTest");
        MessageVo messageVo = historyUtil.resProxy(lottoServiceimpl.execute(new Param().set("count", 10)));
        System.out.println("end");
    }

}
