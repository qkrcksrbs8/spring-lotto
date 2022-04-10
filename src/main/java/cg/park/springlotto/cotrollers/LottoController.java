package cg.park.springlotto.cotrollers;

import cg.park.springlotto.utils.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
public class LottoController {

    @GetMapping("/test")
    public Param test() {
        return new Param()
                .set("aa", 11)
                .set("bb", 22);
    }
}
