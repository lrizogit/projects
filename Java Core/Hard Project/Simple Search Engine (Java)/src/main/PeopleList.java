package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class PeopleList {
    static void printPeople(final String[] data) {
        System.out.println("\n=== List of people ===");
        for (String datum : data) {
            System.out.println(datum);
        }
    }
    public static long textSize(final String[] args) {
        Path path = Paths.get(args[1]);
        long textLength;
        try {
            textLength = Files.lines(path).count();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return textLength;
    }
    static String[] dataArray(final Scanner scan, final int textLen) {
        String[] data1 = new String[textLen];
        while (scan.hasNextLine()) {
            for (int i = 0; i < textLen; i++) {
                data1[i] = scan.nextLine();
            }
        }
        return data1;
    }
    static List<String> listToMap(final Scanner scann, final int textLen) {
        List<String> dataList1 = new ArrayList<>();
        for (int i = 0; i < textLen; i++) {
            dataList1.add(scann.nextLine());
        }
        return dataList1;
    }
    static Map dataMap(final List<String> dataList) {
        Map<String, List<Integer>> mapReturn = new HashMap<>();

        for (int i = 0; i < dataList.size(); i++) {
            String[] names = dataList.get(i).split(" ");
            for (String name : names) {
                if (mapReturn.containsKey(name)) {
                    mapReturn.get(name).add(i);
                } else {
                    List<Integer> index = new ArrayList<>();
                    index.add(i);
                    mapReturn.put(name, index);
                }
            }
        }
        return mapReturn;
    }
}
