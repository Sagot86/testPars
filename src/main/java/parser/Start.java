package parser;

/**
 * А) Вывести список пользователей и используемых ими форм за последний час
 *
 * Б) Вывести список пользователей, которые начали активность на форме и не дошли до конца. Например,
 * для услуг grp dszn_* начальное состояние start, конечное состояние send. Вывести на каком шаге остановился.
 *
 * В) Составить ТОП – 5 самых используемых форм.
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import parser.model.ParsedData;
import parser.service.ParsedDataService;

import java.util.List;

@SpringBootApplication
public class Start {

    public static void main(String[] args) {

        SpringApplication.run(Start.class, args);

        parseCSV();

    }

    private static void parseCSV() {

        Parser parser = new Parser();
        ParsedDataService parsedDataService = new ParsedDataService();

        long start = System.currentTimeMillis();
        System.out.println("\nStart parsing");

        List<ParsedData> parsedData = parser.parse();

        System.out.println("\nParsing complete. Time spent is " + (System.currentTimeMillis() - start));
        start = System.currentTimeMillis();
        System.out.println("\nStart upload");

        parsedDataService.save(parsedData);

        System.out.println("\nUpload complete. Time spent is " + (System.currentTimeMillis() - start));
        System.out.println("\nReady for work!\n");

    }
}
