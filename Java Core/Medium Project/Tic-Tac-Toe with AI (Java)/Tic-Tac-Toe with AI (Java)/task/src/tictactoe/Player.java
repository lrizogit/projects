package tictactoe;

import java.util.Scanner;
import java.util.Random;

public interface Player {
    void play(char[][] tic, boolean rightCoInt, int a, int b, char tm, Scanner scanner, Random random);
    }