package parser.service;

import parser.model.ParsedData;
import parser.repo.ParsedDataRepo;

import java.util.List;
import java.util.Map;

public class ParsedDataService {

    private ParsedDataRepo parsedDataRepo  = new ParsedDataRepo();

    public void save(List<ParsedData> parsedData) {
        parsedDataRepo.save(parsedData);
    }

    public List<Map<String, String>> getFirst() {
        return parsedDataRepo.getFirst();
    }

    public List<Map<String, String>> getSecond() {
        return parsedDataRepo.getSecond();
    }

    public List<Map<Object, Object>> getThird() {
        return parsedDataRepo.getThird();
    }
}
