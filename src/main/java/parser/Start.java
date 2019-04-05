package parser;

/**
 * А) Вывести список пользователей и используемых ими форм за последний час
 *
 * Б) Вывести список пользователей, которые начали активность на форме и не дошли до конца. Например,
 * для услуг grp dszn_* начальное состояние start, конечное состояние send. Вывести на каком шаге остановился.
 *
 * В) Составить ТОП – 5 самых используемых форм.
 */

import parser.model.ParsedData;
import parser.service.ParsedDataService;

import java.util.ArrayList;
import java.util.List;

public class Start {

    public static void main(String[] args) {

        Parser parser = new Parser();
        ParsedDataService parsedDataService = new ParsedDataService();

//        List<ParsedData> parsedData = new ArrayList<>(parser.parse());

        long start = System.currentTimeMillis();

//        parsedDataService.save(parsedData);



        List<ParsedData> secondGet = parsedDataService.getSecond();

        System.out.println(secondGet.get(0).getSsoid());
        System.out.println(secondGet.get(secondGet.size() - 1).getSsoid());
        System.out.println(secondGet.size());

        System.out.println("time is " + (System.currentTimeMillis() - start));

      //  System.out.println(parsedDataService.getFirst());



    }
}
