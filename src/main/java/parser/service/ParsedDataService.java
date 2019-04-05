package parser.service;

import parser.model.ParsedData;
import parser.repo.ParsedDataRepo;

import java.util.List;

public class ParsedDataService {

    private ParsedDataRepo parsedDataRepo  = new ParsedDataRepo();

    public void save(List<ParsedData> parsedData) {
        parsedDataRepo.save(parsedData);
    }

    public List<ParsedData> getFirst() {
        return parsedDataRepo.getFirst();
    }
}
