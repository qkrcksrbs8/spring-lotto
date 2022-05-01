package cg.park.springlotto.services.impl;

import cg.park.springlotto.services.CommandService;
import cg.park.springlotto.utils.DrawNumbersUtil;
import cg.park.springlotto.utils.Param;
import cg.park.springlotto.utils.PcgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Service
public class TestNumberServiceImpl extends CommandService {
    @Autowired
    DrawNumbersUtil lotto;

    @Autowired
    PcgUtil pcgUtil;

    public Param preService(Param param) {
        int count = Integer.parseInt(String.valueOf(param.get("count")));
        if (0 > count || 5 < count) return new Param().set("code", pcgUtil.toEnum("P0001"));
        return new Param().set("code", pcgUtil.toEnum("S0001"));
    }

    public Param postService(Param param) {
        ArrayList<List<Integer>> numbers = lotto.getLottos(Integer.parseInt(String.valueOf(param.get("count"))));
        if (numbers.size() == 0) return new Param().set("code", pcgUtil.toEnum("P0002"));
        return new Param().set("code", pcgUtil.toEnum("S0001")).set("numbers", numbers);
    }

}
