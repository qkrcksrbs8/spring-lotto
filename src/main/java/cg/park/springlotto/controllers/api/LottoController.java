package cg.park.springlotto.controllers.api;

import cg.park.springlotto.comm.SaveProxy;
import cg.park.springlotto.models.MessageDto;
import cg.park.springlotto.services.impl.LottoServiceImpl;
import cg.park.springlotto.services.impl.TopSixImpl;
import cg.park.springlotto.utils.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/test")
@ResponseBody
@Controller
public class LottoController {

    @Autowired
    LottoServiceImpl lottoServiceimpl;

    @Autowired
    SaveProxy proxy;

    @Autowired
    TopSixImpl topSix;

    @GetMapping("/number")
    public MessageDto singleNumber() {
        //public MessageDto singleNumber(HttpRequestServlet req) {
        // req.getParameter("name");
        //public MessageDto singleNumber(EmpDto empDto) {
        // empDto.getEname
        return proxy.resProxy(lottoServiceimpl.execute(new Param().set("count", 1)));
    }

    @GetMapping("/number/{count}")
    public MessageDto multiNumber(@PathVariable("count") int count) {
        return proxy.resProxy(lottoServiceimpl.execute(new Param().set("count", count)));
    }

    @GetMapping("/topSix")
    public MessageDto topSix() {
        return topSix.execute(new Param());
    }

}
