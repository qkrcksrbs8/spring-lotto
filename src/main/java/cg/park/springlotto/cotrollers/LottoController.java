package cg.park.springlotto.cotrollers;

import cg.park.springlotto.services.impl.LottoServiceImpl;
import cg.park.springlotto.services.impl.TestNumberServiceImpl;
import cg.park.springlotto.utils.Lotto;
import cg.park.springlotto.utils.Param;
import cg.park.springlotto.utils.PcgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@ResponseBody
@Controller
public class LottoController {

    @Autowired
    LottoServiceImpl lottoServiceimpl;

    @Autowired
    TestNumberServiceImpl testNumberService;

    @GetMapping("/number")
    public Param number() {
        Param result = testNumberService.execute(new Param().set("count", 1));
        return result;
    }

    @GetMapping("/number/{count}")
    public Param manyNumber(@RequestParam int count) {
        Param param = new Param().set("count", count);
        String preCode = lottoServiceimpl.pre(param);
        if (!preCode.startsWith("S")) return null;
        Param excute = lottoServiceimpl.execute(param);
        return excute;
    }

    @GetMapping("/ask")
    public ResponseEntity<Param> ask() {
        Param result = testNumberService.execute(new Param().set("count", 1));
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(result, status);
    }
}
