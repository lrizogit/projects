package org.example.server;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;

public interface Command {
    String task (JsonElement index, JsonElement data, JsonObject map);
}
