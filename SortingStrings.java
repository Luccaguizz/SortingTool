import java.util.ArrayList;
import java.util.*;

public class SortingStrings {

    public LinkedHashMap<String, Integer> sortedStringsN(HashMap<String, Integer> toSort){

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(toSort.entrySet());

        list.sort(new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                return o1.getKey().compareTo(o2.getKey());
            }
        });

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry : list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }
    public LinkedHashMap<String, Integer> sortedStringsBC(HashMap<String, Integer> toSort){

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(sortedStringsN(toSort).entrySet());

        list.sort(new Comparator<Map.Entry<String, Integer>>(){
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2){
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<String, Integer> entry : list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

}
