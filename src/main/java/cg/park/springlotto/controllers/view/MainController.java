package cg.park.springlotto.controllers.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.StringJoiner;

@RequestMapping("/")
@Controller
public class MainController {

    @GetMapping("/")
    public String index() {
        System.out.println("index 호출");
        return "index";
    }

    public void xxx () {
        System.out.println(info());
    }

    public String info () {
        return new StringJoiner(",")
                .add("1번")
                .add("2번")
                .toString();
    }



}
