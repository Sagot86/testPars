package parser.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import parser.model.ParsedData;
import parser.service.ParsedDataService;

import java.util.List;
import java.util.Map;

@RestController
public class Controller {

    private ParsedDataService parsedDataService = new ParsedDataService();

    @GetMapping("/firstreport")
    public void getUsersAndFormsLastH() {
        List<Map<String, String>> firstGet = parsedDataService.getFirst();
    }

    @GetMapping("/secondreport")
    public void getUsersWhoCantFinish() {
        List<ParsedData> secondGet = parsedDataService.getSecond();
    }

    @GetMapping("/thirdreport")
    public void GetTopFive() {
        List<Map<String, String>> thirdGet = parsedDataService.getThird();
    }

}
