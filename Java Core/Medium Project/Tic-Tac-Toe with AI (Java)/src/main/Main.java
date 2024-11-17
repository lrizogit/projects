package org.example;

import java.util.Random;
import java.util.Scanner;

class Main {
    static int a = 0;
    static int b = 0;
    static char emptyChar = ' ';

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        User user = new User();
        Player p1 = user;
        Player p2 = user;

        char[][] tic = {
                {emptyChar, emptyChar, emptyChar},
                {emptyChar, emptyChar, emptyChar},
                {emptyChar, emptyChar, emptyChar},
        };
        boolean rightCoInt = false;
        boolean rightInputM = false;
        char tm;
        String sta1;

        while (!rightInputM) {
            String[] statements = commandRight(scanner).split(" ");
            sta1 = statements[0];
            if (statements.length < tic.length && !(sta1.equals("exit"))) {
                System.out.println("Bad parameters!");
            } else if (sta1.equals("start")) {

                for (int i = 1; i < statements.length; i++) {
                    switch (i) {
                        case 1 -> p1 = levelSet(i, statements);
                        case 2 -> p2 = levelSet(i, statements);
                        default -> p1 = null;
                    }
                }
                Board.printGraph(tic);
                tm = 'X';
                while (!Board.statusCheck(tic, tm)) {
                    tm = 'X';
                    p1.play(tic, rightCoInt, a, b, tm, scanner, random);
                    Board.printGraph(tic);
                    if (Board.statusCheck(tic, tm)) {
                        break;
                    }
                    tm = 'O';
                    p2.play(tic, rightCoInt, a, b, tm, scanner, random);
                    Board.printGraph(tic);
                    if (Board.statusCheck(tic, tm)) {
                        break;
                    }
                }
                rightInputM = true;
            } else if (sta1.equals("exit")) {
                break;
            } else {
                System.out.println("Bad parameters!");
            }
        }
    }
    public static String commandRight(final Scanner scanner) {
        System.out.print("input command: ");
        return  scanner.nextLine();
    }
    public static Player levelSet(final int i, final String[] statements) {
        switch (statements[i]) {
            case "user" -> {
                return new User();
            }
            case "easy" -> {
                return new Com();
            }
            case "medium" -> {
                return new Medium();
            }
            case "hard" -> {
                return new Hard();
            }
            default -> System.out.println("Bad parameters!");
        }
        return null;
    }
}
