package org.example.client;
import org.junit.jupiter.api.Test;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void readFileAsStringShouldReturnContent() {
        try {
            String content = "Hello, this is a test content.";
            Path tempFile = Files.createTempFile("test", ".txt");
            Files.write(tempFile, content.getBytes());
            String result = Main.readFileAsString(tempFile.toString());
            assertEquals(content, result);
            Files.delete(tempFile);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test
    void readFileAsStringShouldThrowExceptionForNonexistentFile() {
        assertThrows(Exception.class, ()
                -> Main.readFileAsString("nonexistent-file.txt"));
    }
}