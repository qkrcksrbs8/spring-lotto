package cg.park.springlotto.cotrollers;

import cg.park.springlotto.models.MessageDto;
import cg.park.springlotto.services.impl.LottoMstServiceImpl;
import cg.park.springlotto.utils.LottoHistoryUtil;
import cg.park.springlotto.utils.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/mst")
@ResponseBody
@Controller
public class LottoMstController {

    @Autowired
    LottoHistoryUtil historyUtil;

    @Autowired
    LottoMstServiceImpl lottoMstService;

    @GetMapping("/thisWeek")
    public Param thisWeek() {
        return new Param();
    }

    @GetMapping("/history")
    public MessageDto historyList() {
        return historyUtil.resProxy(lottoMstService.execute(new Param()));
    }

}
