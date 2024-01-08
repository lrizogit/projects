package org.example.server;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Remove implements Command {

    public String task(final JsonElement index,
                       final JsonElement data, final JsonObject map) {
        JsonArray indexes = index.getAsJsonArray();
        JsonElement currentElement = map;
        int lastPathIndex = indexes.size() - 1;
        for (int i = 0; i < indexes.size(); i++) {
            try {
                String currentKey = indexes.get(i).getAsString();
                if (currentElement.isJsonObject()) {
                    JsonObject currentObject = currentElement.getAsJsonObject();
                    currentElement = currentObject.get(currentKey);
                    if (i == lastPathIndex) {
                        currentObject.remove(currentKey);
                        String response = "OK";
                        String reason = null;
                        String value = null;
                        Response responseIns =
                                new Response(response, reason, value);
                        Gson gson = new Gson();
                        return gson.toJson(responseIns);
                    }
                }
            } catch (Exception e) {
                String response = "ERROR";
                String reason = "No such key";
                String value = null;
                Response responseIns = new Response(response, reason, value);
                Gson gson = new Gson();
                return gson.toJson(responseIns);
            }
        }
        String response = "ERROR";
        String reason = "No such key";
        String value = null;
        Response responseIns = new Response(response, reason, value);
        Gson gson = new Gson();
        return gson.toJson(responseIns);
    }
}
