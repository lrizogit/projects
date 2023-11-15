package search;

import java.util.*;

public class SearchEngine {
    static void findPerson(String[] data, boolean foundSearch, Map<String, List<Integer>> map, List<String> dataList, Scanner scanner){
        System.out.println("Select a matching strategy: ALL, ANY, NONE");
       // String strategy = scanner.nextLine();
        String[] dataPeople;
        boolean stratLoop = false;
        while(!stratLoop) {
            String strategy = scanner.nextLine();
            switch (strategy) {
                case "ANY":
                    System.out.println("Enter a name or email  to search all suitable people:");
                    dataPeople = scanner.nextLine().split(" ");
                    anyStrategy(dataPeople, map, dataList, foundSearch);
                    stratLoop = true;
                    break;
                case "ALL":
                    System.out.println("Enter a name or email  to search all suitable people:");
                    dataPeople = scanner.nextLine().split(" ");
                    allStrategy(dataPeople, map, dataList, foundSearch);
                    stratLoop = true;
                    break;
                case "NONE":
                    System.out.println("Enter a name or email  to search all suitable people:");
                    dataPeople = scanner.nextLine().split(" ");
                    noneStrategy(dataPeople, map, dataList, foundSearch);
                    stratLoop = true;
                    break;
                default:
                    System.out.println("Strategy not found, try again.");

            }
        }
    }
    static void allStrategy (String[] dataPeople, Map<String, List<Integer>> map, List<String> dataList, boolean foundSearch){
        Set<Integer> foundPeople = new HashSet<>();
        int count = 0;
        for(String findEle : dataPeople) {
            for (String ele : map.keySet()) {
                if (ele.equalsIgnoreCase(findEle) && count == 0) {
                    foundPeople.addAll(map.get(ele));
                } else if (ele.equalsIgnoreCase(findEle)){
                    foundPeople.retainAll(map.get(ele));
                }
            }
            count = count + 1;
        }
        if (foundPeople.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            for (int ele : foundPeople){
                System.out.println(dataList.get(ele));
            }
        }

    }
    static void anyStrategy (String[] dataPeople, Map<String, List<Integer>> map, List<String> dataList, boolean foundSearch){
        foundSearch = false;
        List<String> foundPeople = new ArrayList<>();
        for(String findEle : dataPeople) {
            for (String ele : map.keySet()) {
                if (ele.toUpperCase().equals(findEle.toUpperCase())) {
                    for (int i = 0; i < map.get(ele).size(); i++) {
                        if (!foundPeople.contains(dataList.get(map.get(ele).get(i)))) {
                            foundPeople.add(dataList.get(map.get(ele).get(i)));
                            System.out.println(dataList.get(map.get(ele).get(i)));
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
    static void noneStrategy (String[] dataPeople, Map<String, List<Integer>> map, List<String> dataList, boolean foundSearch){
        foundSearch = false;
        Set<String> foundPeople =  new HashSet<>(dataList);
        for(String findEle : dataPeople) {
            for (String ele : map.keySet()) {
                if (ele.equalsIgnoreCase(findEle)) {
                    for (int i = 0; i < map.get(ele).size(); i++) {
                            foundPeople.remove(dataList.get(map.get(ele).get(i)));
                            foundSearch = true;
                    }
                }
            }
        }
        for (String ele : foundPeople){
            System.out.println(ele);
        }
        if (!foundSearch) {
            System.out.println("No matching people found.");
        }
    }
}
