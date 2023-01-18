import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CaseLong {

    private final HashMap<Long, Integer> values = new HashMap<>();
    private int numberCount;
    Scanner scanner;


    public CaseLong(String filePath) {
        File file = new File(filePath);
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            scanner = new Scanner(System.in);
        }
        numberCount = 0;
        while(scanner.hasNext()){
            Long v = scanner.nextLong();
            Integer count = values.get(v);
            values.put(v, (count == null) ? 1 : ++count);
            numberCount++;
        }
    }

    public HashMap<Long, Integer> getValues() {
        return values;
    }

    public int getNumberCount() {
        return numberCount;
    }

    public String toString(LinkedHashMap<Long, Integer> map, int sortingType){
        StringBuilder result = new StringBuilder("Total Elements: " + numberCount +".\n");
        if(sortingType == 2){
            for(Map.Entry<Long, Integer> entry : map.entrySet()){
                result.append(entry.getKey() + ": " + entry.getValue() + " time(s), " +
                        Math.round(((float) entry.getValue() * 100) / numberCount) + "%\n");
            }
        } else {
            result.append("Sorted data:\n");
            for(Map.Entry<Long, Integer> entry : map.entrySet()){
                result.append((entry.getKey() + " ").repeat(Math.max(0, entry.getValue()))).append("\n");
            }

        }

        return result.toString();
    }
}

