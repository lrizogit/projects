package search;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        File file = new File(args[1]);

        int  textLen = (int) PeopleList.textSize(args);

        try ( Scanner scan = new Scanner(file)){

            String[] data = PeopleList.dataArray(scan, textLen);

            Scanner scann = new Scanner(file);

            List<String> dataList = PeopleList.dataListM(scann, textLen);

            Map<String, List<Integer>> map = PeopleList.dataMap(dataList);

            Menu.menuSelection(data, map, dataList);
        } catch (FileNotFoundException f){
            System.out.println("This file does not exist");
        }
    }

}