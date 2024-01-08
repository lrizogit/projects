package org.example;

import java.util.Random;
import java.util.Scanner;

public class User implements Player {

    public void play(final char[][] tic,
                     boolean rightCoInt, int a, int b,
                     final char tm, final Scanner scanner,
                     final Random random) {
        while (!rightCoInt) {

            System.out.print("Enter the coordinates: ");
            boolean isInt = scanner.hasNextInt();
            if (!isInt) {
                System.out.println("You should enter numbers!");
                scanner.next();
                continue;
            } else {
                a = scanner.nextInt() - 1;
            }
            boolean isIntB = scanner.hasNextInt();
            if (!isIntB) {
                System.out.println("You should enter numbers!");
                scanner.next();
                continue;
            } else {
                b = scanner.nextInt() - 1;
            }
            if (a > 2 || b > 2 || a < 0 || b < 0) {
                System.out.println("Coordinates should be from 1 to 3!");
                scanner.nextLine();
            } else if (tic[a][b] == 'X' || tic[a][b] == 'O') {
                System.out.println("This cell is occupied!"
                        + " Choose another one!");
                scanner.nextLine();
            } else {
                tic[a][b] = tm;
                rightCoInt = true;
            }
        }
    }
}
