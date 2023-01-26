/*
 * Copyright 2016 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

// [START language_quickstart]
// Imports the Google Cloud client

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class QuickstartSample {
    public static void main(String... args) throws Exception {
        SentimentCounter sentimentCounter = new SentimentCounter();
        CustomCSVReader customCSVReader = new CustomCSVReader();
        CustomCSVWriter customCSVWriter = new CustomCSVWriter();
        ArrayList<String[]> data = new ArrayList<String[]>();

        customCSVReader.readCSV().forEach(index -> {
            try {
                data.add(new String[] {index, sentimentCounter.countSentiment(index)});
                System.out.println(index);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
        customCSVWriter.writeToCSV(data);
    }
}
