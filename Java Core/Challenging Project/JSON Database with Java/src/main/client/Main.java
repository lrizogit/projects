package org.example.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import com.beust.jcommander.JCommander;
import com.google.gson.Gson;
import com.beust.jcommander.Parameter;

public class Main {
    @Parameter(names = "-t")
    static String type;
    @Parameter(names = "-k")
    static String key;
    @Parameter(names = "-v")
    static String value;
    @Parameter(names = "-in")
    static String fileName;

    private static final String SERVER_ADDRESS = "127.0.0.1";
    private static final int SERVER_PORT = 2010;
    public Main() {
    }
    public static void main(String... args) throws Exception {
        String jsonString;
        Gson gson = new Gson();
        Main main = new Main();

        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);

        if (fileName != null) {
            String requestFilePath = System.getProperty("user.dir")
                    + "/src/main/java/org/example/client/data/"
                    + fileName;

            jsonString = readFileAsString(requestFilePath);
        } else {
            Request request = new Request(type, key, value);
            jsonString = gson.toJson(request);
        }
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                DataInputStream input =
                        new DataInputStream(socket.getInputStream());
                DataOutputStream output  =
                        new DataOutputStream(socket.getOutputStream());
        ) {
            System.out.println("Client started!");
            output.writeUTF(jsonString);
            System.out.println("Sent: " + jsonString);
            String receivedMsg = input.readUTF();
            System.out.println("Received: " + receivedMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String readFileAsString(final String requestFilePath)
            throws Exception {
        return new String(Files.readAllBytes(Paths.get(requestFilePath)));
    }
}
