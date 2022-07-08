package cg.park.springlotto.utils;

import cg.park.springlotto.daos.HistoryDao;
import cg.park.springlotto.models.LottoNumberDto;
import cg.park.springlotto.models.MessageDto;
import cg.park.springlotto.models.UserLottoHistoryDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class LottoHistoryUtil {

    @Autowired
    HistoryDao historyDao;

    public List<LottoNumberDto> setLottoNumbers(MessageDto messageVo) {
        List<LottoNumberDto> lottoNumbers   = new ArrayList<>();
        ArrayList<List<Integer>> number     = (ArrayList<List<Integer>>) messageVo.getData().get("numbers");
        AtomicInteger cnt                   = new AtomicInteger();
        number.stream().forEach(nums -> {
            List<Integer> numList = new ArrayList(nums);
            Collections.sort(numList);
            Iterator<Integer> num = numList.iterator();
            while(num.hasNext()) {
                LottoNumberDto lottoNumber = new LottoNumberDto();
                lottoNumber.setGroupNo(cnt.getAndIncrement()+1);
                lottoNumber.setFirstNo(num.next());
                lottoNumber.setSecondNo(num.next());
                lottoNumber.setThirdNo(num.next());
                lottoNumber.setForthNo(num.next());
                lottoNumber.setFifthNo(num.next());
                lottoNumber.setSixthNo(num.next());
                lottoNumbers.add(lottoNumber);
            }
        });
        return lottoNumbers;
    }

    private UserLottoHistoryDto setUserInfo(MessageDto messageVo) {
        UserLottoHistoryDto userLottoHistory = new UserLottoHistoryDto();
        userLottoHistory.setMemberNo    (0);
        userLottoHistory.setMemberFlag  ("0");
        userLottoHistory.setRound       (1);
        userLottoHistory.setCreatedUser ("GUEST");
        userLottoHistory.setUpdateUser  ("GUEST");
        userLottoHistory.setLottoNumbers(setLottoNumbers(messageVo));
        return userLottoHistory;
    }

    public void saveMessageHistory (MessageDto messageVo) {
        historyDao.saveUserLottoHistory(setUserInfo(messageVo));
    }

    public HashMap<Integer, Integer> percentageTopSix() {
        Integer[] allLottoNumberPercentage = new Integer[45];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < 46; i++)
            map.put(i, historyDao.historyCount(i));
        return map;
    }

}
