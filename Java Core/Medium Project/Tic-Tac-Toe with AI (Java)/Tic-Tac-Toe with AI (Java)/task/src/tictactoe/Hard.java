package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Hard implements Player {
    public void play(char[][] tic, boolean rightCoInt, int a, int b, char tm, Scanner scanner, Random random){

        int bestScore = Integer.MIN_VALUE;
        int score = 0;
        int bestMoveX = 0;
        int bestMoveY = 0;
        boolean isMax;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tic[i][j] == ' ') {
                    tic[i][j] = tm;
                    score = minimax(tic, score, bestScore, tm, false );
                    tic[i][j] = ' ';
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

    public static int minimax(char[][] tic, int score, int bestScore, char tm, boolean isMax) {
        char tm2 = ' ';
        switch (tm){
            case 'X':
                tm2 = 'O';
                break;
            case 'O':
                tm2 = 'X';
        }
        if (Board.anyWinnerHard(tic, tm)) {
            return 1;
        } else if (!Board.anyWinnerHard(tic, tm) && Board.anyWinner(tic) ) {
            return -1;
        } else if (!(tic[0][0] == ' ' || tic[1][0] == ' ' || tic[2][0] == ' ' ||
                tic[0][1] == ' ' || tic[1][1] == ' ' || tic[2][1] == ' ' ||
                tic[0][2] == ' ' || tic[1][2] == ' ' || tic[2][2] == ' ')) {
            return 0;
        }
        if (isMax) {
            bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tic[i][j] == ' ') {
                        tic[i][j] = tm;
                        score = minimax(tic, score, bestScore, tm, false);
                        tic[i][j] = ' ';
                        if (score > bestScore) {
                            bestScore = score;
                           // System.out.println("check");
                        }
                    }
                }
            }
            return bestScore;
        } else {
            bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tic[i][j] == ' ') {
                        tic[i][j] = tm2;
                        score = minimax(tic, score, bestScore, tm, true);
                        tic[i][j] = ' ';
                        if (score < bestScore) {
                            bestScore = score;
                           // System.out.println("check");
                        }
                    }
                }
            }
            return bestScore;
        }
    }
}
