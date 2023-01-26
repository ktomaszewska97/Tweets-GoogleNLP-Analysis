import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

public class CustomCSVReader {

    private static final String FILENAME = "/Users/karolina.tomaszewska/resource_02_en.csv";
    CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
    ArrayList<String> textArray = new ArrayList<>();

    public ArrayList<String> readCSV() throws IOException, CsvException {

        try (CSVReader reader = new CSVReaderBuilder(
                new FileReader(FILENAME))
                .withCSVParser(csvParser)
                .build()) {
            String[] lineInArray;
            while ((lineInArray = reader.readNext()) != null) {
                textArray.add(lineInArray[1]);
            }
        }
        return textArray;
    }


}
