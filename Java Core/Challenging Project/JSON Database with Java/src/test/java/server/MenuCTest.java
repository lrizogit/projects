package org.example.server;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MenuCTest {
    JsonObject map = new JsonObject();
    String com;
    JsonElement data = null;
    JsonObject request;
    Commands commando = new Commands();
    @Test
    void menuSet() {
        String json = "{\"type\":\"set\",\"key\":\"name\",\"value\":\"Kate\"}";
        com = "set";
        request = JsonParser.parseString(json).getAsJsonObject();
        MenuC.menu(com, map, request);
        assertEquals(MenuC.menu(com, map, request),
                "{\"response\":\"OK\"}");
    }
    @Test
    void menuDefault() {
        String json = "{\"type\":\"test\",\"key\":\"name\",\"value\":\"Kate\"}";
        com = "test";
        request = JsonParser.parseString(json).getAsJsonObject();
        MenuC.menu(com, map, request);
        assertEquals(MenuC.menu(com, map, request),
                "{\"response\":\"ERROR\",\"reason\":\"Invalid type\"}");
    }
    @Test
    void menuGetFail() {
        String json = "{\"type\":\"get\",\"key\":[\"name\"]}";
        com = "get";
        request = JsonParser.parseString(json).getAsJsonObject();
        MenuC.menu(com, map, request);
        assertEquals(MenuC.menu(com, map, request),
                "{\"response\":\"ERROR\",\"reason\":\"No such key\"}");
    }
    @Test
    void menuGet() {
        String json = "{\"type\":\"set\",\"key\":\"name\",\"value\":\"Kate\"}";
        request = JsonParser.parseString(json).getAsJsonObject();
        commando.setCommand(new Set());
        JsonElement index = request.get("key");
        data = request.get("value");
        commando.task(index, data, map);
        String json1 = "{\"type\":\"get\",\"key\":[\"name\"]}";
        com = "get";
        JsonObject request1 = JsonParser.parseString(json1).getAsJsonObject();
        MenuC.menu(com, map, request1);
        assertEquals(MenuC.menu(com, map, request),
                "{\"response\":\"OK\",\"value\":\"Kate\"}");
    }
   @Test
    void menuDelete() {
        String json = "{\"type\":\"set\",\"key\":\"name\",\"value\":\"Kate\"}";
        request = JsonParser.parseString(json).getAsJsonObject();
        commando.setCommand(new Set());
        JsonElement index = request.get("key");
        data = request.get("value");
        commando.task(index, data, map);
        String json1 = "{\"type\":\"delete\",\"key\":[\"name\"]}";
        com = "delete";
        JsonObject request1 = JsonParser.parseString(json1).getAsJsonObject();
        assertEquals(MenuC.menu(com, map, request1),
                "{\"response\":\"OK\"}");
    }
    @Test
    void menuExit() {
        String json = "{\"type\":\"exit\"}";
        com = "exit";
        request = JsonParser.parseString(json).getAsJsonObject();
        MenuC.menu(com, map, request);
        assertEquals(MenuC.menu(com, map, request),
                "{\"response\":\"OK\"}");
    }

}
