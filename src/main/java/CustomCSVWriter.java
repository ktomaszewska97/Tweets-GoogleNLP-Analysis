import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

public class CustomCSVWriter {
    private static final String FILENAME = "/Users/karolina.tomaszewska/resource_02_with_sentiment.csv";

    public void writeToCSV(ArrayList<String[]> data) throws IOException {
        File file = new File(FILENAME);
        try {
            FileWriter outputfile = new FileWriter(file);
            CSVWriter writer = new CSVWriter(outputfile);
            writer.writeAll(data);
            writer.close();
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
