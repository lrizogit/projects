package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class MediumTest {
    Medium medium;
    Scanner scanner;
    Random random;
    char[][] tic;


    @BeforeEach
    void setUp() {
        medium = new Medium();
        scanner = new Scanner(System.in);
        random = new Random();
        tic = new char[][] {
                {'X', 'X', 'O'},
                {' ', 'O', ' '},
                {' ', ' ', ' '},
        };
    }

    @Test
    void PlayMediumTest() {
        char tm = 'X';
        String simulatedInput = "0 2";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        medium.play(tic, false, 1,3, tm, scanner, random);
        System.out.println();
        assertEquals('X', tic[2][0]);
    }
    @Test
    void MediumBoardCheckTest() {
        char[][] tic = {
                {'X', 'X', 'O'},
                {' ', 'O', 'X'},
                {'O', ' ', ' '},
        };
        char tm = 'X';
        char tmM = tm;
        assertEquals(true, medium.mediumBoardCheck(tic, tmM, tm));
    }

}