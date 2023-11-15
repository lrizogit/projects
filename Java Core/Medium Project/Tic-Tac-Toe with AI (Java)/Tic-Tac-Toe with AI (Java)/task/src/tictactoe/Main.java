package tictactoe;
//import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;
import java.util.Random;

public class Main {
    static int a = 0;
    static int b = 0;

    public static void main(String[] args) {
        // write your code here
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        User user = new User();
        //Com com = new Com();
       // Medium medium = new Medium();
       // Hard hard = new Hard();
        char[][] tic = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '},
        };
        boolean rightCoInt = false;
        boolean rightInputM = false;
        char d = ' ';
        char tm = ' ';
        String sta1 = null;
        Player p1 = user;
        Player p2 = user;


        while (!rightInputM) {
            String[] statements = commandRight(scanner).split(" ");
            sta1 = statements[0];
            if (statements.length < 3 && !(sta1.equals("exit"))) {
                System.out.println("Bad parameters!");
            } else if (sta1.equals("start")){

                for (int i = 1; i < statements.length; i++) {
                    if (statements[i].equals("user")) {
                        if (i == 1) p1 = new User();
                        else if (i == 2) p2 = new User();
                    } else if (statements[i].equals("easy")) {
                        if (i == 1) p1 = new Com();
                        else if (i == 2) p2 = new Com();
                    } else if (statements[i].equals("medium")) {
                        if (i == 1) p1 = new Medium();
                        else if (i == 2) p2 = new Medium();
                    } else if (statements[i].equals("hard")) {
                        if (i == 1) p1 = new Hard();
                        else if (i == 2) p2 = new Hard();
                    } else {
                        System.out.println("Bad parameters!");
                        break;
                    }
                }
                Board.printGraph(tic);
                while (!Board.statusCheck(tic, d, tm)) {
                    tm = 'X';
                    p1.play(tic, rightCoInt, a, b, tm, scanner, random);
                    Board.printGraph(tic);
                    if (Board.statusCheck(tic, d, tm)) {
                        break;
                    }
                    tm = 'O';
                    p2.play(tic, rightCoInt, a, b, tm, scanner, random);
                    Board.printGraph(tic);
                    if (Board.statusCheck(tic, d, tm)) {
                        break;
                    }
                }
                rightInputM = true;
            }else if (sta1.equals("exit")){
                break;
            }else {
                System.out.println("Bad parameters!");
            }
        }
    }
    public static String commandRight(Scanner scanner){
        System.out.print("input command: ");
        return  scanner.nextLine();
    }
}