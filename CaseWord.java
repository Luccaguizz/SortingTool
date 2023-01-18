import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CaseWord {

    private final HashMap<String, Integer> words = new HashMap<>();
    public int wordCount;
    Scanner scanner = new Scanner(System.in);

    public CaseWord(String filePath){
        File file = new File(filePath);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            scanner = new Scanner(System.in);
        }
        wordCount = 0;
        while (scanner.hasNext()){
            String s = scanner.next();
            Integer count = words.get(s);
            words.put(s, (count == null) ? 1 : ++count);
            wordCount++;
        }
    }

    public HashMap<String, Integer> getWords() {
        return words;
    }

    public int getWordCount() {
        return wordCount;
    }

    public String toString(LinkedHashMap<String, Integer> map, int sortingType){
        StringBuilder result = new StringBuilder("Total Elements: " + wordCount +".\n");
        if(sortingType == 2){
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                result.append(entry.getKey() + ": " + entry.getValue() + " time(s), " +
                        Math.round(((float) entry.getValue() * 100) / wordCount) + "%\n");
            }
        } else {
            result.append("Sorted data:\n");
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                result.append((entry.getKey() + " ").repeat(Math.max(0, entry.getValue()))).append("\n");
            }

        }

        return result.toString();
    }
}
