package cg.park.springlotto.services.impl;

import cg.park.springlotto.daos.HistoryDao;
import cg.park.springlotto.services.CommandService;
import cg.park.springlotto.utils.LottoHistoryUtil;
import cg.park.springlotto.utils.Param;
import cg.park.springlotto.utils.PcgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;

@Service
public class TopSixImpl extends CommandService {

    @Autowired
    PcgUtil pcgUtil;

    @Autowired
    HistoryDao historyDao;

    @Autowired
    LottoHistoryUtil lottoHistoryUtil;

    public Param preService(Param param) {
        return new Param().set("code", pcgUtil.toEnum("S0001"));
    }

    public Param postService(Param param) {
        Integer[] allLottoNumberPercentage = lottoHistoryUtil.percentageTopSix();
        Arrays.sort(allLottoNumberPercentage, Collections.reverseOrder());
        return new Param().set("code", pcgUtil.toEnum("S0001")).set("topSix", allLottoNumberPercentage);
    }
}
