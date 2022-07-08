package cg.park.springlotto.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/")
@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        System.out.println("index 호출");
        return "index";
    }
}
