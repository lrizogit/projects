package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Random;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.*;

class HardTest {
    Scanner scanner;
    Random random;
    char[][] tic;
    char tm;
    Hard hard;
    @BeforeEach
    void setUp() {
        scanner = new Scanner(System.in);
        random = new Random();
        hard = new Hard();
    }

    @Test
    void PlayHardTest() {
        char[][] tic = {
                {'X', 'X', 'O'},
                {' ', 'O', ' '},
                {' ', ' ', ' '},
        };
        char tm = 'X';
        String simulatedInput = "0 2";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        hard.play(tic, false, 1,3, tm, scanner, random);
        System.out.println();
        assertEquals('X', tic[2][0]);
    }
    @Test
    void HardBoardCheckTest() {
        char[][] tic = {
                {'X', 'X', 'O'},
                {' ', 'O', 'X'},
                {'O', ' ', ' '},
        };
        char tm = 'O';
        assertEquals(true, hard.anyWinnerHard(tic, tm));
    }
}
