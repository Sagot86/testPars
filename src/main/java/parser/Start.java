package parser;

import parser.model.ParsedData;
import parser.service.ParsedDataService;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {

        Parser parser = new Parser();
        ParsedDataService parsedDataService = new ParsedDataService();

        List<ParsedData> parsedData = new ArrayList<>(parser.parse());

        long start = System.currentTimeMillis();

        parsedDataService.save(parsedData);

        System.out.println(System.currentTimeMillis() - start);

      //  System.out.println(parsedDataService.getFirst());



    }
}
