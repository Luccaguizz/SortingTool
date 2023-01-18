import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CaseLine {

    private HashMap<String, Integer> lines = new HashMap<>();
    private int lineCount;
    Scanner scanner = new Scanner(System.in);

    public CaseLine(String filePath){
        File file = new File(filePath);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            scanner = new Scanner(System.in);
        }
        lineCount = 0;
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            Integer count = lines.get(line);
            lines.put(line, (count == null) ? 1 : ++count);
            lineCount++;
        }
    }

    public HashMap<String, Integer> getLines() {
        return lines;
    }

    public int getLineCount() {
        return lineCount;
    }

    public String toString(LinkedHashMap<String, Integer> map, int sortingType){
        StringBuilder result = new StringBuilder("Total Elements: " + lineCount +".\n");
        if(sortingType == 2){
            for(Map.Entry<String, Integer> entry : map.entrySet()){
                result.append(entry.getKey() + ": " + entry.getValue() + " time(s), " +
                        Math.round(((float) entry.getValue() * 100) / lineCount) + "%\n");
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
