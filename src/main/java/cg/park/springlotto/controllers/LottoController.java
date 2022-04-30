package cg.park.springlotto.controllers;

import cg.park.springlotto.comm.SaveProxy;
import cg.park.springlotto.models.MessageDto;
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

    @Autowired
    SaveProxy proxy;

    // 단일 로또 번호 조회
    @GetMapping("/number")
    public MessageDto singleNumber() {
        return proxy.resProxy(lottoServiceimpl.execute(new Param().set("count", 1)));
    }

    // 다중 로또 번호 조회
    @GetMapping("/number/{count}")
    public MessageDto multiNumber(@PathVariable("count") int count) {
        return proxy.resProxy(lottoServiceimpl.execute(new Param().set("count", count)));
    }

}
