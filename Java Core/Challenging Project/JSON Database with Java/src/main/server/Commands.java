package org.example.server;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

public class Commands {
    private Command command;
    public void setCommand(final Command command) {
        this.command = command;
    }
    public String task(final JsonElement index,
                       final JsonElement data, final JsonObject map) {
        return command.task(index, data, map);
    }
}
