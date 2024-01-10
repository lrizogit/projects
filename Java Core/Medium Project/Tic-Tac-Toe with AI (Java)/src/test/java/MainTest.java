package org.example;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.io.FileOutputStream;
import java.io.FileDescriptor;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void mainTest() {
        String simulatedInput = "start easy easy";
        InputStream savedSystemIn = System.in;
        System.setIn(new ByteArrayInputStream(simulatedInput.getBytes()));
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        Main.main(null);

        System.setIn(savedSystemIn);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        String output = outputStreamCaptor.toString().trim();
        assertFalse("X wins".equals(output)
                || "Draw".equals(output) || "O wins".equals(output));
    }
}