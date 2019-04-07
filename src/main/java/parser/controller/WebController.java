package parser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Controller
@EnableWebMvc
@RequestMapping("/reports")
public class WebController {

    @GetMapping("/1")
    public String first() {
        return "firstreport";
    }

    @RequestMapping("/2")
    public String second() {
        return "secondreport";
    }

    @RequestMapping("/3")
    public String third() {
        return "thirdreport";
    }


}
