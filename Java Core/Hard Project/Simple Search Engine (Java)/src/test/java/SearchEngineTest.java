package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.*;
import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchEngineTest {
    String strategy;
    Map<String, List<Integer>> map;
    List<String> dataList;
    String[] dataPeople;
    boolean foundSearch;
    Scanner scanner;

    @BeforeEach
    void setUp() {
        scanner = new Scanner(System.in);
        dataList = new ArrayList<>();
        dataList.add("John Phillip Simpson");
        dataList.add("Lisa Simpson Johnson");
        dataList.add("Carmelo Martinez Lisartan");
        map = PeopleList.dataMap(dataList);
        dataPeople = new String[]{"Lisa", "Phillip", "John"};
    }
    @Test
    void findPersonAny() {
        String input = "ANY\nJohn\nALL\nDoe\nNONE\nSmith\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Map<String, List<Integer>> map = new HashMap<>();
        List<String> dataList = new ArrayList<>();
        dataList.add("John Doe");
        dataList.add("Jane Smith");

        SearchEngine.findPerson(false, map, dataList, new Scanner(System.in));

        System.setIn(System.in);
        System.setOut(System.out);
        String actualOutput = outputStream.toString().trim();

        assertEquals("Select a matching strategy: ALL, ANY, NONE\n" +
                "Enter a name or email to search all suitable people:\n" +
                "No matching people found.", actualOutput);
    }
    @Test
    void findPersonAll() {
        String input = "ALL\nJohn\nALL\nDoe\nNONE\nSmith\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Map<String, List<Integer>> map = new HashMap<>();
        List<String> dataList = new ArrayList<>();
        dataList.add("John Doe");
        dataList.add("Jane Smith");

        SearchEngine.findPerson(false, map, dataList, new Scanner(System.in));

        System.setIn(System.in);
        System.setOut(System.out);
        String actualOutput = outputStream.toString().trim();

        assertEquals("Select a matching strategy: ALL, ANY, NONE\n" +
                "Enter a name or email to search all suitable people:\n" +
                "No matching people found.", actualOutput);
    }
    @Test
    void findPersonNone() {
        String input = "NONE\nJohn\nALL\nDoe\nNONE\nSmith\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        Map<String, List<Integer>> map = new HashMap<>();
        List<String> dataList = new ArrayList<>();
        dataList.add("John Doe");
        dataList.add("Jane Smith");

        SearchEngine.findPerson(false, map, dataList, new Scanner(System.in));

        System.setIn(System.in);
        System.setOut(System.out);
        String actualOutput = outputStream.toString().trim();

        assertEquals("Select a matching strategy: ALL, ANY, NONE\n" +
                "Enter a name or email to search all suitable people:\n" +
                "John Doe\n" +
                "Jane Smith\n" +
                "No matching people found.", actualOutput);
    }

    @Test
    void anyStrategy() {
        strategy = "ANY";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SearchEngine.anyStrategy(dataPeople, map, dataList, foundSearch);
        String printedOutput = outputStream.toString().trim();
        assertEquals(printedOutput, "Lisa Simpson Johnson\n" +
                "John Phillip Simpson");
    }
    @Test
    void allStrategy() {
        strategy = "ALL";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SearchEngine.allStrategy(dataPeople, map, dataList, foundSearch);
        String printedOutput = outputStream.toString().trim();
        assertEquals(printedOutput, "No matching people found.");
    }
    @Test
    void noneStrategy() {
        strategy = "NONE";

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        SearchEngine.noneStrategy(dataPeople, map, dataList, foundSearch);
        String printedOutput = outputStream.toString().trim();
        assertEquals(printedOutput, "Carmelo Martinez Lisartan");
    }
}