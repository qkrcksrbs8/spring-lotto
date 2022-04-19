package cg.park.springlotto.cotrollers;

import cg.park.springlotto.utils.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/mst")
@ResponseBody
@Controller
public class LottoMstController {

    @GetMapping("/thisWeek")
    public Param thisWeek() {
        return new Param();
    }

    @GetMapping("/history")
    public Param historyList() {
        return new Param();
    }

}
