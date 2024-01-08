package org.example.server;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MenuC {
    public static String menu(final String com,
                               final JsonObject map, final JsonObject request) {
        ReadWriteLock lock = new ReentrantReadWriteLock();
        Commands commando = new Commands();
        JsonElement index;
        JsonElement data = null;
        String response;
        String reason = null;
        String value = null;
        String taskRes;
        Response responseIns;
        Gson gson;
            try {
                switch (com) {
                    case "set" -> {
                        lock.readLock().lock();
                        index = request.get("key");
                        data = request.get("value");
                        commando.setCommand(new Set());
                        taskRes = commando.task(index, data, map);
                        lock.readLock().unlock();
                        return taskRes;
                    }
                    case "get" -> {
                        lock.writeLock().lock();
                        index = request.get("key");
                        commando.setCommand(new Get());
                        taskRes = commando.task(index, data, map);
                        lock.writeLock().unlock();
                        return taskRes;
                    }
                    case "delete" -> {
                        lock.readLock().lock();
                        index = request.get("key");
                        commando.setCommand(new Remove());
                        taskRes = commando.task(index, data, map);
                        lock.readLock().unlock();
                        return taskRes;
                    }
                    case "exit" -> {
                        response = "OK";
                        responseIns = new Response(response, reason, value);
                        gson = new Gson();
                        return gson.toJson(responseIns);
                    }
                    default -> {
                        response = "ERROR";
                        reason = "Invalid type";
                        responseIns = new Response(response, reason, value);
                        gson = new Gson();
                        return gson.toJson(responseIns);
                    }
                }
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                response = "ERROR";
                reason = "Invalid type";
                responseIns = new Response(response, reason, value);
                gson = new Gson();
                return gson.toJson(responseIns);
            }
    }
}
