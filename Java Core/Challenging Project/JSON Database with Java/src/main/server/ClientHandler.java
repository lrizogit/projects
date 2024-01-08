package org.example.server;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private final Socket clientSocket;
    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }
    JsonObject map = Main.map2;

    public void run() {
        Response.writeJsonObjectToFile(map);
        try (
                DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
        ) {
            String json = input.readUTF();
            JsonObject request = JsonParser.parseString(json).getAsJsonObject();
            String com = request.get("type").getAsString();
            output.writeUTF(MenuC.menu(com, map, request));
            Main.msg = com;

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
        Response.writeJsonObjectToFile(map);
    }
}