package cg.park.springlotto.services.impl;

import cg.park.springlotto.daos.HistoryDao;
import cg.park.springlotto.services.CommandService;
import cg.park.springlotto.utils.Param;
import cg.park.springlotto.utils.PcgUtil;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.Collections;

public class TopSixImpl extends CommandService {

    @Autowired
    PcgUtil pcgUtil;

    @Autowired
    HistoryDao historyDao;

    public Param preService(Param param) {
        return new Param().set("code", pcgUtil.toEnum("S0001"));
    }

    public Param postService(Param param) {
        Integer[] allLottoNumberPercentage = new Integer[45];
        for (int i = 0; i < 45; i++)
            allLottoNumberPercentage[i] = historyDao.historyCount(i);

        Arrays.sort(allLottoNumberPercentage, Collections.reverseOrder());
        return new Param().set("code", pcgUtil.toEnum("S0001")).set("topSix", allLottoNumberPercentage);
    }
}
