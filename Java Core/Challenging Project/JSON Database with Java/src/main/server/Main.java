package org.example.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.google.gson.JsonObject;

public class Main {
    static String msg = "0";
    private static final int PORT = 2010;
     static JsonObject map2 = new JsonObject();

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newCachedThreadPool();

        try (ServerSocket server = new ServerSocket(PORT)) {
            while (!Main.msg.equals("exit")) {
                Future<?> future = executorService.submit(new ClientHandler(server.accept()));
                future.get();
            }
        } catch (IOException e) {

            e.printStackTrace();

        } catch (ExecutionException | InterruptedException e) {

            throw new RuntimeException(e);

        }
    }
}