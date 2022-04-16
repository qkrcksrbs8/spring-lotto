package cg.park.springlotto.services.impl;

import cg.park.springlotto.services.Command;
import cg.park.springlotto.utils.Lotto;
import cg.park.springlotto.utils.Param;
import cg.park.springlotto.utils.PcgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


@Service
public class TestNumberServiceImpl extends Command {
    @Autowired
    Lotto lotto;

    @Autowired
    PcgUtil pcgUtil;

    public Param pre(Param param) {
        int count = Integer.parseInt(String.valueOf(param.get("count")));
        if (0 > count || 5 < count) return new Param().set("code", pcgUtil.toEnum("P0001"));
        return new Param().set("code", pcgUtil.toEnum("S0001"));
    }

    public Param post(Param param) {
        List<Set<Integer>> numbers = lotto.getLottos(Integer.parseInt(String.valueOf(param.get("count"))));
        if (numbers.size() == 0) return new Param().set("code", pcgUtil.toEnum("P0002"));
        return new Param().set("code", pcgUtil.toEnum("S0001")).set("numbers", numbers);
    }

}
