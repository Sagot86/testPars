package parser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import parser.service.ParsedDataService;

import java.util.List;
import java.util.Map;

@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/restresult")
public class ServiceController {

    private ParsedDataService parsedDataService = new ParsedDataService();


    @GetMapping(path = "/1")
    public List<Map<String, String>> getUsersAndFormsLastH() {
        return parsedDataService.getFirst();
    }

    @GetMapping(path = "/2")
    public List<Map<String, String>> getUsersWhoCantFinish() {
        return parsedDataService.getSecond();
    }

    @GetMapping(path = "/3")
    public List<Map<Object, Object>> GetTopFive() {
        return parsedDataService.getThird();
    }
}
