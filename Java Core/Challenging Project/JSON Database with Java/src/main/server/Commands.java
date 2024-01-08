package org.example.server;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Commands {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public String task(JsonElement index, JsonElement data, JsonObject map) {
        return command.task(index, data, map);
    }
}
