package org.example.server;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Set implements Command {
    public String task(final JsonElement index,
                       final JsonElement data, final JsonObject map) {
        if (index.isJsonPrimitive()) {
            map.add(index.getAsString(), data);
        } else if (index.isJsonArray()) {
            JsonArray indexes = index.getAsJsonArray();
            modifyJsonValue(map, indexes, data);
        }
            String response = "OK";
            String reason = null;
            String value = null;
            Response responseIns = new Response(response, reason, value);
            Gson gson = new Gson();
            return gson.toJson(responseIns);
    }
    private static void modifyJsonValue(final JsonObject map,
                                        final JsonArray indexes,
                                        final JsonElement data) {
        JsonElement currentElement = map;
        int lastPathIndex = indexes.size() - 1;

        for (int i = 0; i < indexes.size() - 1; i++) {
            String currentKey = indexes.get(i).getAsString();
            String currentKeyPlus = indexes.get(i + 1).getAsString();
            currentElement = currentElement.getAsJsonObject().get(currentKey);
            if (i == lastPathIndex - 1) {
                currentElement.getAsJsonObject().add(currentKeyPlus, data);
            }
        }
    }
}
