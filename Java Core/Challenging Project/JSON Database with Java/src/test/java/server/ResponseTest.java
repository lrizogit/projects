package org.example.server;

import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ResponseTest {

    @Test
    public void testWriteJsonObjectToFile() {
        JsonObject jsonObject = new JsonObject();

        Response.writeJsonObjectToFile(jsonObject);

        Path filePath = Paths.get("/Users/lrizo/Documents/MavenUdemy/JSON Database with Java/src/main/java/org/example/server/data/db.json");
        assertTrue(Files.exists(filePath));

        try {
            String content = Files.readString(filePath);
            assertEquals(jsonObject.toString(), content.trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Files.delete(filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}