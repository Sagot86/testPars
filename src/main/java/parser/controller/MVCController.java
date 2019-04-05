package parser.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import parser.model.ParsedData;

import java.util.Collections;
import java.util.List;

@Controller
public class MVCController {

    @GetMapping("/firstreport")
    public List<ParsedData> getUsersAndFormsLastH() {
        return Collections.emptyList();
    }

}
