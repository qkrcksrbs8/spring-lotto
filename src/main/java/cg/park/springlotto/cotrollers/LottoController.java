package cg.park.springlotto.cotrollers;

import cg.park.springlotto.comm.constant.MessageEnum;
import cg.park.springlotto.models.Message;
import cg.park.springlotto.services.impl.LottoServiceImpl;
import cg.park.springlotto.services.impl.TestNumberServiceImpl;
import cg.park.springlotto.utils.Param;
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

    // 단일 로또 번호 조회
    @GetMapping("/number")
    public Message number() {
        return testNumberService.execute(new Param().set("count", 1));
    }

    // 다중 로또 번호 조회
    @GetMapping("/number/{count}")
    public Message manyNumber(@RequestParam int count) {
        return testNumberService.execute(new Param().set("count", count));
    }

    @GetMapping("/ask")
    public ResponseEntity<Message> ask() {
        Message result = testNumberService.execute(new Param().set("count", 1));
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(result, status);
    }
}
