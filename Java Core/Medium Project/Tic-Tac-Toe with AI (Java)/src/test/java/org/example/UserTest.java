package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileDescriptor;
import java.io.ByteArrayOutputStream;
import java.util.Random;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    @Test
    void play() {
        user = new User();
        char[][] tic = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        boolean rightCoInt = false;
        int a = 0;
        int b = 0;
        char tm = 'X';

        String simulatedInput = "1 1";
        InputStream savedSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));

        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));

        user.play(tic, rightCoInt, a, b, tm, new Scanner(System.in), new Random());

        System.setIn(savedSystemIn);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));

        assertEquals('X', tic[0][0]);
    }
}