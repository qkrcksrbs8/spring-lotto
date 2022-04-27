package cg.park.springlotto.services.impl;

import cg.park.springlotto.daos.HistoryDao;
import cg.park.springlotto.services.CommandService;
import cg.park.springlotto.utils.Param;
import cg.park.springlotto.utils.PcgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ThisWeekServiceImpl extends CommandService {

    @Autowired
    PcgUtil pcgUtil;

    @Autowired
    HistoryDao historyDao;

    public Param preService(Param param) {
        return new Param().set("code", pcgUtil.toEnum("S0001"));
    }

    public Param postService(Param param) {
        Param thisWeekNumbers = historyDao.thisWeek();
        return new Param().set("code", pcgUtil.toEnum("S0001")).set("thisWeekNumbers", thisWeekNumbers);
    }
}
