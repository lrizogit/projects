package tictactoe;

import java.util.Random;
import java.util.Scanner;

public class Board {
    public static void printGraph(char[][] tic) {
        System.out.println("---------");
        System.out.println("| " + tic[0][0] + " " + tic[0][1] + " " + tic[0][2] + " |");
        System.out.println("| " + tic[1][0] + " " + tic[1][1] + " " + tic[1][2] + " |");
        System.out.println("| " + tic[2][0] + " " + tic[2][1] + " " + tic[2][2] + " |");
        System.out.println("---------");
    }
    public static boolean statusCheck(char[][] tic, char d, char tm) {
        if (anyWinner(tic)) {
            System.out.println(tm + " wins");
            return true;
        } else if (!(tic[0][0] == ' ' || tic[1][0] == ' ' || tic[2][0] == ' ' ||
                tic[0][1] == ' ' || tic[1][1] == ' ' || tic[2][1] == ' ' ||
                tic[0][2] == ' ' || tic[1][2] == ' ' || tic[2][2] == ' ')) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
    public static boolean anyWinner(char[][] tic) {
        if ((tic[0][0] == tic[0][1] && tic[0][0] == tic[0][2] && tic[0][0] != ' ' ||
                tic[0][0] == tic[1][1] && tic[0][0] == tic[2][2] && tic[0][0] != ' ' ||
                tic[0][0] == tic[1][0] && tic[0][0] == tic[2][0] && tic[0][0] != ' ' ||
                tic[1][0] == tic[1][1] && tic[1][0] == tic[1][2] && tic[1][0] != ' ' ||
                tic[2][0] == tic[2][1] && tic[2][0] == tic[2][2] && tic[2][0] != ' ' ||
                tic[0][1] == tic[1][1] && tic[0][1] == tic[2][1] && tic[0][1] != ' ' ||
                tic[0][2] == tic[1][2] && tic[0][2] == tic[2][2] && tic[0][2] != ' ' ||
                tic[2][0] == tic[1][1] && tic[2][0] == tic[0][2] && tic[2][0] != ' ')) {
            return true;
        }
        return false;
    }
    public static boolean anyWinnerHard(char[][] tic, char tm ) {
        if ((tic[0][0] == tic[0][1] && tic[0][0] == tic[0][2] && tic[0][0] == tm ||
                tic[0][0] == tic[1][1] && tic[0][0] == tic[2][2] && tic[0][0] == tm ||
                tic[0][0] == tic[1][0] && tic[0][0] == tic[2][0] && tic[0][0] == tm ||
                tic[1][0] == tic[1][1] && tic[1][0] == tic[1][2] && tic[1][0] == tm ||
                tic[2][0] == tic[2][1] && tic[2][0] == tic[2][2] && tic[2][0] == tm ||
                tic[0][1] == tic[1][1] && tic[0][1] == tic[2][1] && tic[0][1] == tm ||
                tic[0][2] == tic[1][2] && tic[0][2] == tic[2][2] && tic[0][2] == tm ||
                tic[2][0] == tic[1][1] && tic[2][0] == tic[0][2] && tic[2][0] == tm )) {
            return true;
        }
        return false;
    }
}