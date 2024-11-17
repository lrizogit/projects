package org.example;

import java.util.Random;
import java.util.Scanner;

public class Medium implements Player {
    public void play(final char[][] tic,
                     final boolean rightCoInt, int a, int b,
                     final char tm, final Scanner scanner,
                     final Random random) {
        char tmM = tm;
        boolean medright = false;
        while (!medright) {
          medright = mediumBoardCheck(tic, tmM, tm);
          if (medright) {
              break;
          }
            switch (tm) {
                case 'X' -> tmM = 'O';
                case 'O' -> tmM = 'X';
                default -> tmM = ' ';
            }
            medright = mediumBoardCheck(tic, tmM, tm);
            if (medright) {
                break;
            }
            a = random.nextInt(tic.length);
            b = random.nextInt(tic.length);
            while (tic[a][b] != Main.emptyChar) {
                a = random.nextInt(tic.length);
                b = random.nextInt(tic.length);
            }
            tic[a][b] = tm;
            medright = true;
        }
        System.out.println("Making move level \"medium\" ");
    }
    public boolean mediumBoardCheck(final char[][] tic,
                                    final char tmM, final char tm) {
        for (int i = 0; i < tic.length; i++) {
            for (int j = 0; j < tic.length; j++) {
                if (tic[i][j] == Main.emptyChar) {
                    tic[i][j] = tmM;
                    if (Board.anyWinner(tic)) {
                        tic[i][j] = tm;
                        return true;
                    } else {
                        tic[i][j] = Main.emptyChar;
                    }
                }
            }
        }
        return false;
    }
}
