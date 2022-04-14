package cg.park.springlotto.services.impl;

import cg.park.springlotto.comm.constant.MessageEnum;
import cg.park.springlotto.services.Command;
import cg.park.springlotto.utils.Lotto;
import cg.park.springlotto.utils.Param;
import cg.park.springlotto.utils.PcgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TestNumberServiceImpl extends Command {
    @Autowired
    Lotto lotto;

    @Autowired
    PcgUtil pcgutil;

    public Param pre(Param param) {
        int count = Integer.parseInt(String.valueOf(param.get("count")));
        if (0 > count && 6 < count) return new Param().set("code", "P0001");
        return new Param().set("code", "S0001");
    }

    public Param post(Param param) {
        int[][] numbers = pcgutil.setToArray(lotto.getLottos(Integer.parseInt(String.valueOf(param.get("count")))));
        if (numbers.length == 0) return new Param().set("code", "P0002");
        return new Param().set("code", "S0001").set("numbers", numbers);
    }
}
