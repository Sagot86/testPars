package parser;

import parser.model.Entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Parser {

    List<Entity> parse() {

        String csvFile = "src/main/resources/test_case.csv";
        String csvSplitBy = ";";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            String line;
            List<Entity> entitiesList = new ArrayList<>();

            //Skip header
            br.readLine();

            while ((line = br.readLine()) != null) {

                String[] entities = line.split(csvSplitBy);

                entitiesList.add(new Entity(
                        entities[0],
                        entities[1],
                        entities[2],
                        entities[3],
                        entities[4],
                        entities[5],
                        entities[6],
                        entities[7],
                        entities[8],
                        entities[9],
                        entities[10],
                        new SimpleDateFormat("yyyy-MM-dd-HH").parse(entities[11], new ParsePosition(0))
                        ));
            }

            return entitiesList;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}