package cg.park.springlotto.cotrollers;

import cg.park.springlotto.models.MessageVo;
import cg.park.springlotto.services.impl.LottoServiceImpl;
import cg.park.springlotto.utils.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/test")
@ResponseBody
@Controller
public class LottoController {

    @Autowired
    LottoServiceImpl lottoServiceimpl;

    // 단일 로또 번호 조회
    @GetMapping("/number")
    public MessageVo number() {
        return lottoServiceimpl.execute(new Param().set("count", 1));
    }

    // 다중 로또 번호 조회
    @GetMapping("/number/{count}")
    public MessageVo manyNumber(@PathVariable("count") int count) {
        return lottoServiceimpl.execute(new Param().set("count", count));
    }

    @GetMapping("/ask")
    public ResponseEntity<MessageVo> ask() {
        MessageVo result = lottoServiceimpl.execute(new Param().set("count", 1));
        HttpStatus status = HttpStatus.OK;
        return new ResponseEntity<>(result, status);
    }
}
