package cg.park.springlotto.utils;

import cg.park.springlotto.models.LottoNumberVo;
import cg.park.springlotto.models.MessageVo;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class LottoHistoryUtil {

    public List<LottoNumberVo> saveMessageHistory(MessageVo messageVo) {
        List<LottoNumberVo> lottoNumbers = new ArrayList<>();
        List<Set<Integer>> number = (List<Set<Integer>>) messageVo.getData().get("numbers");
        AtomicInteger cnt= new AtomicInteger();
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

}
