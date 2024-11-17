package org.example;

class Board {
    static void printGraph(final char[][] tic) {
        System.out.println("---------");
        System.out.println("| " + tic[0][0] + " "
                + tic[0][1] + " " + tic[0][2] + " |");
        System.out.println("| " + tic[1][0] + " "
                + tic[1][1] + " " + tic[1][2] + " |");
        System.out.println("| " + tic[2][0] + " "
                + tic[2][1] + " " + tic[2][2] + " |");
        System.out.println("---------");
    }
    static boolean statusCheck(final char[][] tic, final char tm) {
        if (anyWinner(tic)) {
            System.out.println(tm + " wins");
            return true;
        } else if (isFull(tic)) {
            System.out.println("Draw");
            return true;
        }
        return false;
    }
    static boolean isFull(final char[][] tic) {
        for (int i = 0; i < tic.length; i++) {
            if (tic[0][i] == Main.emptyChar
                    || tic[1][i] == Main.emptyChar
                    || tic[2][i] == Main.emptyChar) {
                return false;
            }
        }
        return true;
    }
    public static boolean anyWinner(final char[][] tic) {
        for (int i = 0; i < tic.length; i++) {
            if (tic[i][0] == tic[i][1]
                    && tic[i][0] == tic[i][2]
                    && tic[i][0] != Main.emptyChar) {
                return true;
            }
        }
        for (int i = 0; i < tic.length; i++) {
            if (tic[0][i] == tic[1][i]
                    && tic[0][i] == tic[2][i]
                    && tic[0][i] != Main.emptyChar) {
                return true;
            }
        }
        if (tic[0][0] == tic[1][1]
                && tic[0][0] == tic[2][2]
                && tic[0][0] != Main.emptyChar) {
            return true;
        }
        if (tic[2][0] == tic[1][1]
                && tic[2][0] == tic[0][2]
                && tic[2][0] != Main.emptyChar) {
            return true;
        }
        return false;
    }
}
