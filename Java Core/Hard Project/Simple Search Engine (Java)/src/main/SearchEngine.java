package org.example;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

public class SearchEngine {
    static final String NOT_FOUND = "No matching people found.";
    static void findPerson(final boolean foundSearch, final Map<String,
            List<Integer>> map, final List<String> dataList,
                           final Scanner scanner) {
        String[] dataPeople;
        boolean stratLoop = false;
        final String EMPTY = " ";
        final String ENTER_NAME = "Enter a name or email"
                + " to search all suitable people:";
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
        while (!stratLoop) {
            String strategy = scanner.nextLine();
            switch (strategy) {
                case "ANY" -> {
                    System.out.println(ENTER_NAME);
                    dataPeople = scanner.nextLine().split(EMPTY);
                    anyStrategy(dataPeople, map, dataList, foundSearch);
                    stratLoop = true;
                }
                case "ALL" -> {
                    System.out.println(ENTER_NAME);
                    dataPeople = scanner.nextLine().split(EMPTY);
                    allStrategy(dataPeople, map, dataList, foundSearch);
                    stratLoop = true;
                }
                case "NONE" -> {
                    System.out.println(ENTER_NAME);
                    dataPeople = scanner.nextLine().split(EMPTY);
                    noneStrategy(dataPeople, map, dataList, foundSearch);
                    stratLoop = true;
                }
                default -> System.out.println("Strategy not found, try again.");
            }
        }
    }
    static void allStrategy(final String[] dataPeople, final Map<String,
            List<Integer>> map, final List<String> dataList,
                             boolean foundSearch) {
        Set<Integer> foundPeople = new HashSet<>();
        int count = 0;
        for (String findEle : dataPeople) {
            for (String ele : map.keySet()) {
                List<Integer> mapElement = map.get(ele);
                if (ele.equalsIgnoreCase(findEle) && count == 0) {
                    foundPeople.addAll(mapElement);
                } else if (ele.equalsIgnoreCase(findEle)) {
                    foundPeople.retainAll(mapElement);
                }
            }
            count++;
        }
        if (foundPeople.isEmpty()) {
            System.out.println(NOT_FOUND);
        } else {
            for (int ele : foundPeople) {
                System.out.println(dataList.get(ele));
            }
        }
    }
    static void anyStrategy(final String[] dataPeople, final Map<String,
            List<Integer>> map, final List<String> dataList,
                            boolean foundSearch) {
        foundSearch = false;
        List<String> foundPeople = new ArrayList<>();
        for (String findEle : dataPeople) {
            for (String ele : map.keySet()) {
                if (ele.toUpperCase().equals(findEle.toUpperCase())) {
                    for (int i = 0; i < map.get(ele).size(); i++) {
                        if (!foundPeople.contains(dataList.get(map
                                .get(ele).get(i)))) {
                            foundPeople.add(dataList.get(map.get(ele).get(i)));
                            System.out.println(dataList.get(map
                                    .get(ele).get(i)));
                            foundSearch = true;
                        }
                    }
                }
            }
        }
        foundPeople.clear();
        if (!foundSearch) {
            System.out.println("No matching people found.");
        }
    }

    static void noneStrategy(final String[] dataPeople, final Map<String,
            List<Integer>> map, final List<String> dataList,
                             boolean foundSearch) {
        foundSearch = false;
        Set<String> foundPeople =  new HashSet<>(dataList);
        for (String findEle : dataPeople) {
            for (String ele : map.keySet()) {
                if (ele.equalsIgnoreCase(findEle)) {
                    for (int i = 0; i < map.get(ele).size(); i++) {
                        foundPeople.remove(dataList.get(map.get(ele).get(i)));
                        foundSearch = true;
                    }
                }
            }
        }
        for (String ele : foundPeople) {
            System.out.println(ele);
        }
        if (!foundSearch) {
            System.out.println("No matching people found.");
        }
    }
}
