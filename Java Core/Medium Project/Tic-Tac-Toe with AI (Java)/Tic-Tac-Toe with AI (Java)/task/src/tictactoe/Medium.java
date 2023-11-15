package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Medium implements Player{

    public void play(char[][] tic, boolean rightCoInt, int a, int b, char tm, Scanner scanner, Random random){
        char tmM = tm;
        boolean medright = false;
        outerloop:
        while(!medright) {

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tic[i][j] == ' ') {
                        tic[i][j] = tmM;
                        if (Board.anyWinner(tic)) {
                            tic[i][j] = tm;
                            medright = true;
                            break outerloop;
                        } else {
                            tic[i][j] = ' ';
                        }
                    }
                }
            }
            switch (tm){
                case 'X':
                    tmM = 'O';
                    break;
                case 'O':
                    tmM = 'X';
                    break;
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (tic[i][j] == ' ') {
                        tic[i][j] = tmM;
                        if (Board.anyWinner(tic)) {
                            tic[i][j] = tm;
                            medright = true;
                            break outerloop;
                        } else {
                            tic[i][j] = ' ';
                        }
                    }
                }
            }
            a = random.nextInt(3);
            b = random.nextInt(3);
            while (tic[a][b] != ' ') {
                a = random.nextInt(3);
                b = random.nextInt(3);
            }
            tic[a][b] = tm;
            medright = true;
        }

        System.out.println("Making move level \"medium\" ");

    }
}
