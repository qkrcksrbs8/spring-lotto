package cg.park.springlotto.controllers.api;

import cg.park.springlotto.models.MessageDto;
import cg.park.springlotto.services.impl.LottoMstServiceImpl;
import cg.park.springlotto.services.impl.ThisWeekServiceImpl;
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

    @Autowired
    ThisWeekServiceImpl thisWeekService;

    @GetMapping("/thisweek")
    public MessageDto thisWeek() {
        return thisWeekService.execute(new Param());
    }

    @GetMapping("/history")
    public MessageDto historyList() {
        return lottoMstService.execute(new Param());
    }

}
