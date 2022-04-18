package cg.park.springlotto.utils;

import cg.park.springlotto.daos.LottoDao;
import cg.park.springlotto.models.LottoNumberVo;
import cg.park.springlotto.models.MessageVo;
import cg.park.springlotto.models.UserLottoHistoryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class LottoHistoryUtil {

    @Autowired
    LottoDao lottoDao;

    public List<LottoNumberVo> setLottoNumbers(MessageVo messageVo) {
        List<LottoNumberVo> lottoNumbers    = new ArrayList<>();
        List<Set<Integer>> number           = (List<Set<Integer>>) messageVo.getData().get("numbers");
        AtomicInteger cnt                   = new AtomicInteger();
        number.stream().forEach(nums -> {
            Iterator<Integer> num = nums.iterator();
            while(num.hasNext()) {
                LottoNumberVo lottoNumber = new LottoNumberVo();
                lottoNumber.setGroupNo(cnt.getAndIncrement()+1);
                lottoNumber.setFirstNo(num.next());
                lottoNumber.setSecondNo(num.next());
                lottoNumber.setThirdNo(num.next());
                lottoNumber.setForthNo(num.next());
                lottoNumber.setFifthNo(num.next());
                lottoNumbers.add(lottoNumber);
            }
        });
        return lottoNumbers;
    }

    private UserLottoHistoryVo setUserInfo(MessageVo messageVo) {
        UserLottoHistoryVo userLottoHistory = new UserLottoHistoryVo();
        userLottoHistory.setMemberNo    (0);
        userLottoHistory.setMemberFlag  ("0");
        userLottoHistory.setRound       (1);
        userLottoHistory.setCreatedUser ("GUEST");
        userLottoHistory.setUpdateUser  ("GUEST");
        userLottoHistory.setLottoNumbers(setLottoNumbers(messageVo));
        return userLottoHistory;
    }

    private void saveMessageHistory (MessageVo messageVo) {
        lottoDao.saveUserLottoHistory(setUserInfo(messageVo));
    }

    public MessageVo resProxy(MessageVo messageVo) {
        if (messageVo.getCode().startsWith("S")) saveMessageHistory(messageVo);
        return messageVo;
    }

}
