import java.util.*;

public class SortingLongs {

    public LinkedHashMap<Long, Integer> sortedLongsN(HashMap<Long, Integer> toSort){
        List<Map.Entry<Long, Integer>> list = new ArrayList<>(toSort.entrySet());

        list.sort(new Comparator<Map.Entry<Long, Integer>>() {
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                return (o1.getKey().compareTo(o2.getKey()));
            }
        });

        LinkedHashMap<Long, Integer> sortedMap = new LinkedHashMap<>();
        for(Map.Entry<Long, Integer> entry: list){
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public LinkedHashMap<Long, Integer> sortedLongsBC(HashMap<Long, Integer> toSort) {
        ArrayList<Map.Entry<Long, Integer>> list = new ArrayList<>(sortedLongsN(toSort).entrySet());

        list.sort(new Comparator<Map.Entry<Long, Integer>>() {
            public int compare(Map.Entry<Long, Integer> o1, Map.Entry<Long, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        LinkedHashMap<Long, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<Long, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;

    }
}
