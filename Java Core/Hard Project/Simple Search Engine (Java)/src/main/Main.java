package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        File file = new File(args[1]);
        int  textLen = (int) PeopleList.textSize(args);

        try (Scanner scan = new Scanner(file)) {
            String[] data = PeopleList.dataArray(scan, textLen);
            Scanner scann = new Scanner(file);
            List<String> dataList = PeopleList.listToMap(scann, textLen);
            Map<String, List<Integer>> map = PeopleList.dataMap(dataList);
            Menu.menuSelection(data, map, dataList);

        } catch (FileNotFoundException f) {
            throw new RuntimeException();
        }
    }
}
