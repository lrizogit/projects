package org.example.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import java.io.FileWriter;
import java.io.IOException;

public class Response {
    String response;
    String reason;
    String value;
    public Response (String response, String reason, String value) {
        this.response = response;
        this.reason = reason;
        this.value = value;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static void writeJsonObjectToFile(JsonObject map) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(map);
        try (FileWriter fileWriter = new
                FileWriter("/Users/lrizo/Documents/MavenUdemy/JSON Database with Java" +
                        "/src/main/java/org/example/server/data/db.json")) {
            fileWriter.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

