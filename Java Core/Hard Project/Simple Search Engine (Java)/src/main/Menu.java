package org.example;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    static void printMenu() {
        System.out.println("\n=== Menu === \n"
                + "1. Find a person \n"
                + "2. Print all people \n"
                + "0. Exit");
    }
    static void menuSelection(final String[] data, final Map<String,
            List<Integer>> map, final List<String> dataList) {
        boolean foundSearch = false;
        boolean exitMenu = false;
        String selectMenu;

        while (!exitMenu) {
            Menu.printMenu();
            Scanner scanner = new Scanner(System.in);
            selectMenu = scanner.nextLine();
            switch (selectMenu) {
                case "1" -> SearchEngine.findPerson(foundSearch,
                        map, dataList, scanner);
                case "2" -> PeopleList.printPeople(data);
                case "0" -> {
                    System.out.println("Bye!");
                    exitMenu = true;
                }
                default -> System.out.println("Incorrect option! Try again.");
            }
        }
    }
}
