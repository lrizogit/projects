package org.example;

import java.util.Random;
import java.util.Scanner;

public class Hard implements Player {
    public void play(final char[][] tic,
                     final boolean rightCoInt, int a, int b,
                     final char tm, final Scanner scanner,
                     final Random random) {

        int bestScore = Integer.MIN_VALUE;
        int score = 0;
        int bestMoveX = 0;
        int bestMoveY = 0;

        for (int i = 0; i < tic.length; i++) {
            for (int j = 0; j < tic.length; j++) {
                if (tic[i][j] == Main.emptyChar) {
                    tic[i][j] = tm;
                    score = minimax(tic, score, tm, false);
                    tic[i][j] = Main.emptyChar;
                    if (score > bestScore) {
                        bestScore = score;
                        bestMoveX = i;
                        bestMoveY = j;
                    }
                }
            }
        }
        tic[bestMoveX][bestMoveY] = tm;
        System.out.println("Making move level \"hard\" ");
    }

    public static int minimax(final char[][] tic, int score,
                              final char tm, final boolean isMax) {
        char tm2 = switch (tm) {
            case 'X' -> 'O';
            case 'O' -> 'X';
            default -> Main.emptyChar;
        };
        if (anyWinnerHard(tic, tm)) {
            return 1;
        } else if (!anyWinnerHard(tic, tm) && Board.anyWinner(tic)) {
            return -1;
        } else if (Board.isFull(tic)) {
            return 0;
        }
        int bestScore;
        if (isMax) {
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < tic.length; i++) {
                for (int j = 0; j < tic.length; j++) {
                    if (tic[i][j] == Main.emptyChar) {
                        tic[i][j] = tm;
                        score = minimax(tic, score, tm, false);
                        tic[i][j] = Main.emptyChar;
                        if (score > bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        } else {
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < tic.length; i++) {
                for (int j = 0; j < tic.length; j++) {
                    if (tic[i][j] == Main.emptyChar) {
                        tic[i][j] = tm2;
                        score = minimax(tic, score, tm, true);
                        tic[i][j] = Main.emptyChar;
                        if (score < bestScore) {
                            bestScore = score;
                        }
                    }
                }
            }
            return bestScore;
        }
    }
    public static boolean anyWinnerHard(final char[][] tic, final char tm) {
        for (int i = 0; i < tic.length; i++) {

            if (tic[i][0] == tic[i][1]
                    && tic[i][0] == tic[i][2]
                    && tic[i][0] == tm) {
                return true;
            }
        }
        for (int i = 0; i < tic.length; i++) {

            if (tic[0][i] == tic[1][i]
                    && tic[0][i] == tic[2][i]
                    && tic[0][i] == tm) {
                return true;
            }
        }
        if (tic[0][0] == tic[1][1]
                && tic[0][0] == tic[2][2]
                && tic[0][0] == tm) {
            return true;
        }
        if (tic[2][0] == tic[1][1]
                && tic[2][0] == tic[0][2]
                && tic[2][0] == tm) {
            return true;
        }
        return false;
    }
}
