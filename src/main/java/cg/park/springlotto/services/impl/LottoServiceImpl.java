package cg.park.springlotto.services.impl;

import cg.park.springlotto.services.Execute;
import cg.park.springlotto.utils.Lotto;
import cg.park.springlotto.utils.Param;
import cg.park.springlotto.utils.PcgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LottoServiceImpl implements Execute {

    @Autowired
    PcgUtil pcgUtil;

    @Autowired
    Lotto lotto;

    public String pre(Param param) {
        int count = Integer.parseInt(String.valueOf(param.get("count")));
        if (0 > count && 6 < count) return "P0001";
        return "S0001";
    }

    public Param execute(Param param) {
        int[][] numbers = pcgUtil.setToArray(lotto.getLottos(Integer.parseInt(String.valueOf(param.get("count")))));
        if (numbers.length == 0) return new Param().set("code", "P0002");
        return new Param().set("code", "S0001").set("numbers", numbers);
    }

    public void post() {

    }
}
