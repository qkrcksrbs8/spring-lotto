package cg.park.springlotto.services.impl;

import cg.park.springlotto.daos.HistoryDao;
import cg.park.springlotto.models.HistoryCountDto;
import cg.park.springlotto.services.Command;
import cg.park.springlotto.utils.Param;
import cg.park.springlotto.utils.PcgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LottoMstServiceImpl extends Command {

    @Autowired
    PcgUtil pcgUtil;

    @Autowired
    HistoryDao historyDao;

    public Param pre(Param param) {
        return new Param().set("code", pcgUtil.toEnum("S0001"));
    }

    public Param post(Param param) {
        HistoryCountDto historyCount = historyDao.selectHistoryCount();
        return new Param().set("code", pcgUtil.toEnum("S0001")).set("lottoPercentage", historyCount);
    }
}
