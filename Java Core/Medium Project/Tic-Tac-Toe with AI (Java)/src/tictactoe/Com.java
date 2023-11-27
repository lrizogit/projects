package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Com implements Player{

    public void play(char[][] tic, boolean rightCoInt, int a, int b, char tm, Scanner scanner, Random random){
        a = random.nextInt(3);
        b = random.nextInt(3);
        while (tic[a][b] != ' ') {
            a = random.nextInt(3);
            b = random.nextInt(3);
        }
        System.out.println("Making move level \"easy\" ");
        tic[a][b] = tm;
    }
    public static void randomCom(char[][] tic, int a, int b, Random random){
        a = random.nextInt(3);
        b = random.nextInt(3);
        while (tic[a][b] != ' ') {
            a = random.nextInt(3);
            b = random.nextInt(3);
        }
    }
}