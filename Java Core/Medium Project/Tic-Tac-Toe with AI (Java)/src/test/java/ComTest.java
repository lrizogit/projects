package org.example;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.util.Random;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ComTest {
    
    @Test
    void PlayComTest() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        char[][] tic = {
                {'X', 'X', 'O'},
                {' ', 'O', ' '},
                {' ', ' ', ' '},
        };
        char tm = 'X';
        Com com = new Com();
        String simulatedInput = "1 2";
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        com.play(tic, false, 1,2, tm, scanner, random);
        assertEquals(true, 'X' == tic[0][1] ||
                'X' == tic[0][2] || 'X' == tic[1][2] || 'X' == tic[2][1] || 'X' == tic[2][2]);
    }

}