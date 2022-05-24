package cg.park.springlotto.services.impl;

import cg.park.springlotto.services.CommandService;
import cg.park.springlotto.utils.DrawNumbersUtil;
import cg.park.springlotto.utils.Param;
import cg.park.springlotto.utils.PcgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LottoServiceImpl extends CommandService {

    @Autowired
    DrawNumbersUtil draw;

    @Autowired
    PcgUtil pcgUtil;

    public Param preService(Param param) {
        return (isBetweenMinAndMax(0, 5, Integer.parseInt(String.valueOf(param.get("count")))))
                ? new Param().set("code", pcgUtil.toEnum("S0001"))
                : new Param().set("code", pcgUtil.toEnum("P0001"));
    }
    
    private boolean isBetweenMinAndMax (int min, int max, int count) {
        return min >= count || max < count;
    }

    public Param postService(Param param) {
        ArrayList<List<Integer>> numbers = draw.getLottos(Integer.parseInt(String.valueOf(param.get("count"))));
        return (numbers.size() == 0)
                ? new Param().set("code", pcgUtil.toEnum("P0002"))
                : new Param().set("code", pcgUtil.toEnum("S0001")).set("numbers", numbers);
    }
}
