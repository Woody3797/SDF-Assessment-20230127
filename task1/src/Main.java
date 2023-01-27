package src;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    public static void main(String[] args) throws IOException {

        String dirPath = "./src";
        String fileName = args[0];
        File file = new File(dirPath + File.separator + fileName);
        String line = "";
        List<String> words = new ArrayList<>();
        Map<String, Integer> wordCount = new ConcurrentHashMap<>();
        int count = 0;

        if (!file.exists()) {
            System.out.println("file does not exist, input correct filename");
        }

        BufferedReader br = new BufferedReader(new FileReader(file));

        while ((line = br.readLine()) != null) {
            String[] wordArr = line.replaceAll("[^a-zA-Z ]", "").toLowerCase().split(" ");

            for (String word : wordArr) {
                if (word.length() > 0) {
                    words.add(word);
                }
            }
        }

        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }


        while (count < 10) {
            int maxValue = Collections.max(wordCount.values());
            for (String key : wordCount.keySet()) {
                if (wordCount.get(key) == maxValue) {
                    System.out.println(key + ": " + wordCount.get(key));
                    wordCount.remove(key);
                }
            }
            count++;
        }

        br.close();
    }
}
