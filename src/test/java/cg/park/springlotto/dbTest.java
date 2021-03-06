package cg.park.springlotto;

import cg.park.springlotto.comm.SaveProxy;
import cg.park.springlotto.daos.HistoryDao;
import cg.park.springlotto.daos.LottoDao;
import cg.park.springlotto.models.HistoryCountDto;
import cg.park.springlotto.models.MessageDto;
import cg.park.springlotto.models.UserLottoHistoryDto;
import cg.park.springlotto.services.impl.LottoServiceImpl;
import cg.park.springlotto.utils.LottoHistoryUtil;
import cg.park.springlotto.utils.Param;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

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
            MessageDto result = lottoServiceimpl.execute(new Param().set("count", 1));
            UserLottoHistoryDto userLottoHistory = new UserLottoHistoryDto();
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
            MessageDto result = lottoServiceimpl.execute(new Param().set("count", 5));
            UserLottoHistoryDto userLottoHistory = new UserLottoHistoryDto();
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
    SaveProxy proxy;

    public void PrintMessageDto (MessageDto messageDto) {
        System.out.println("========== START Print Message ==========");
        System.out.println(messageDto.getCode());
        System.out.println(messageDto.getMessage());
        System.out.println(messageDto.getData().toString());
        System.out.println("========== E N D Print Message ==========");
    }

    // 단일 로또 API 테스트
    @Test
    public void singleLottoTest() {
        System.out.println("singleLottoTest");
        MessageDto messageDto = proxy.resProxy(lottoServiceimpl.execute(new Param().set("count", 1)));
        PrintMessageDto(messageDto);
    }


    // 다중 로또 API 테스트
    @Test
    public void MultiLottoTest() {
        System.out.println("MultiLottoTest");
        MessageDto messageDto = proxy.resProxy(lottoServiceimpl.execute(new Param().set("count", 5)));
        PrintMessageDto(messageDto);
    }


    // 다중 로또 API 오류 테스트
    @Test
    public void MultiLottoErrorTest() {
        System.out.println("MultiLottoTest");
        MessageDto messageDto = proxy.resProxy(lottoServiceimpl.execute(new Param().set("count", 10)));
        PrintMessageDto(messageDto);
    }


    @Autowired
    HistoryDao historyDao;

    // 로또 역대 당첨 횟수 1개
    @Test
    public void historyCountTest() {
        System.out.println("historyCountTest");
        int count = historyDao.historyCount(3);
        System.out.println(count);
        System.out.println("end");
    }

    // 로또 당첨 횟수 업데이트
    @Test
    public void multiHistoryCountTest() {
        System.out.println("multiHistoryCountTest");
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 45; i++) {
            map.put("no"+i, historyDao.historyCount(i));
        }
        map.put("round", 1018);
        historyDao.updateHistoryCount(map);
        System.out.println(map);
        System.out.println("end");
    }

    // 로또번호 당첨 퍼센트
    @Test
    public void lottoPercentage() {
        HistoryCountDto historyCount = historyDao.selectNumbersPercentage();
        System.out.println(historyCount.toString());
    }

    @Test
    public void thisWeekTest() {
        Param param = historyDao.thisWeek();
        System.out.println(param.toString());
    }

    @Test
    public void topSix() {
        HashMap<Integer, Integer>  map = lottoHistoryUtil.percentageTopSix();
        List<Map.Entry<Integer, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));
        for (int i = 1; i < 7; i++) {
            System.out.println(entries.get(i));
        }
    }

}
