package search;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class PeopleList {
    static void printPeople(String[] data){
        System.out.println("\n=== List of people ===");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i]);
        }
    }
    public static long textSize(String[] args){
        Path path = Paths.get(args[1]);
        long textLength = 0L;
        try{
            textLength = Files.lines(path).count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return textLength;
    }
    static String[] dataArray (Scanner scan, int textLen){
        String[] data1 = new String[textLen];
        while (scan.hasNextLine()) {
            for (int i = 0 ; i < textLen; i++){
                data1[i] = scan.nextLine();
            }
        }
        return data1;
    }
    static List<String> dataListM (Scanner scann, int textLen){
        List<String> dataList1 = new ArrayList<>();

        for ( int i = 0; i < textLen; i++){
            dataList1.add(scann.nextLine());
        }
        return dataList1;
    }
    static Map dataMap (List<String> dataList){

        Map<String, List<Integer>> map1 = new HashMap<>();

        for (int i = 0 ; i < dataList.size(); i++ ) {
            String[] names = dataList.get(i).split(" ");
            for (int j = 0 ; j < names.length; j++) {
                if (map1.containsKey(names[j])) {
                    map1.get(names[j]).add(i);
                } else {
                    List<Integer> index = new ArrayList<>();
                    index.add(i);
                    map1.put(names[j], index);
                }
            }
        }
        return map1;
    }
}
