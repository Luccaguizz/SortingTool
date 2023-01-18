import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> arguments = new HashMap<>();
        // Data Type
        // 0 -> No arguments
        // 1 -> Long
        // 2 -> Word
        // 3 -> Line
        // Sorting Type
        // 0 -> No Argument/Natural
        // 1 -> By Count
        int dataType = 0;
        int sortingType = 0;
        String inputFile = null;
        String outputFile = null;
        try {

            for (String s: args){
                Integer count = arguments.get(s);
                arguments.put(s, (count == null) ? 1 : count + 1);

            }
            int i = 0;
            for(String s: args){
                arguments.put(s, i++);
            }


        } catch (IndexOutOfBoundsException e){
            System.out.println("Out of bounds :(");
        }
        int valueOfInput= -1;
        int valueOfOutput= -1;

            for(Map.Entry<String, Integer> entry : arguments.entrySet()){
                if(entry.getKey().equals("-inputFile"))
                    valueOfInput = entry.getValue() + 1;
                if(entry.getKey().equals("-outputFile"))
                    valueOfOutput = entry.getValue() + 1;

            }
            for(Map.Entry<String, Integer> entry : arguments.entrySet()){
                if(entry.getValue() == valueOfInput){
                    inputFile = entry.getKey();
                }
                if(entry.getValue() == valueOfOutput){
                    outputFile = entry.getKey();
                }
            }



        if(arguments.containsKey("-dataType")){
            if(arguments.containsKey("long"))
                dataType = 1;
            else if (arguments.containsKey("word"))
                dataType = 2;
            else if (arguments.containsKey("line"))
                dataType = 3;
            else
                dataType = 1;
        } else
            dataType = 1;


        if(arguments.containsKey("-sortingType")){
            if(arguments.containsKey("natural"))
                sortingType = 1;
            else if (arguments.containsKey("byCount"))
                sortingType = 2;
        }

        //Creating Output file
            File output = new File(outputFile);




        // Create an Object containg a hash map with words, lines or number with their respectives occurencies.
        switch (dataType){
            case 1: // long
                LinkedHashMap<Long, Integer> sortedLongList = null;
                CaseLong longObj = new CaseLong(inputFile);
                if(sortingType == 2) // if I want also to order By count
                    sortedLongList = new SortingLongs().sortedLongsBC(longObj.getValues());
                else
                    sortedLongList = new SortingLongs().sortedLongsN(longObj.getValues());
                //print
                try {
                    FileWriter result = new FileWriter(output, false);
                    result.write(longObj.toString(sortedLongList, sortingType));
                    result.close();
                } catch (IOException e) {
                    System.out.println(longObj.toString(sortedLongList, sortingType));
                }
                break;
            case 2: // word
                LinkedHashMap<String, Integer> sortedWordList = null;
                CaseWord wordObj = new CaseWord(inputFile);
                if(sortingType == 2) // if I want also to order By count
                    sortedWordList = new SortingStrings().sortedStringsBC(wordObj.getWords());
                else
                    sortedWordList = new SortingStrings().sortedStringsN(wordObj.getWords());
                //print
                try {
                    FileWriter result = new FileWriter(output, false);
                    result.write(wordObj.toString(sortedWordList, sortingType));
                    result.close();
                } catch (IOException e) {
                    System.out.println(wordObj.toString(sortedWordList, sortingType));
                }

                break;
            case 3: // line
                LinkedHashMap<String, Integer> sortedLineList = null;
                CaseLine lineObj = new CaseLine(inputFile);
                if(sortingType == 2) // if I want also to order By count
                    sortedLineList = new SortingStrings().sortedStringsBC(lineObj.getLines());
                else
                    sortedLineList = new SortingStrings().sortedStringsN(lineObj.getLines());
                //print
                try {
                    FileWriter result = new FileWriter(output, false);
                    result.write(lineObj.toString(sortedLineList, sortingType));
                    result.close();
                } catch (IOException e) {
                    System.out.println(lineObj.toString(sortedLineList, sortingType));
                }
                break;
            default:
                throw new IllegalArgumentException("Not valid arg!");
        }



    }

    private static <G> String toString(LinkedHashMap<G, Integer> map, int sortingType, int count){
        StringBuilder result = new StringBuilder("Total Elements: " + count +".\n");
        if(sortingType == 2){
            for(Map.Entry<G, Integer> entry : map.entrySet()){
                result.append(entry.getKey() + ": " + entry.getValue() + " time(s), " +
                        Math.round(((float) entry.getValue() * 100) / count) + "%\n");
            }
        } else {
            result.append("Sorted data: ");
            for(Map.Entry<G, Integer> entry : map.entrySet()){
                    result.append((entry.getKey() + " ").repeat(Math.max(0, entry.getValue())));
            }

        }

        return result.toString();
    }
}