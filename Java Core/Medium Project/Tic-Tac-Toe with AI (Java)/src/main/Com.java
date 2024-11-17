package org.example;

import java.util.Random;
import java.util.Scanner;

public class Com implements Player {

    public void play(final char[][] tic,
                     final boolean rightCoInt, int a, int b,
                     final char tm, final Scanner scanner,
                     final Random random) {
        a = random.nextInt(tic.length);
        b = random.nextInt(tic.length);
        while (tic[a][b] != Main.emptyChar) {
            a = random.nextInt(tic.length);
            b = random.nextInt(tic.length);
        }
        System.out.println("Making move level \"easy\" ");
        tic[a][b] = tm;
    }
}
