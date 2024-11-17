package org.example.server;

import com.google.gson.Gson;
import org.example.client.Request;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ClientHandlerTest {

    @Test
    void testRun() throws IOException {
        Request request = new Request("set", "name", "Kate");
        Gson gson = new Gson();
        String inputJson = gson.toJson(request);

        System.setIn(new ByteArrayInputStream(inputJson.getBytes()));

        Socket mockedSocket = mock(Socket.class);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        when(mockedSocket.getOutputStream()).thenReturn(new DataOutputStream(outContent));
        when(mockedSocket.getInputStream()).thenReturn(new DataInputStream(new ByteArrayInputStream(inputJson.getBytes())));

        ClientHandler handler = new ClientHandler(mockedSocket);
        handler.run();
        assertEquals("{\"response\":\"OK\"}", outContent.toString().trim());

    }
}
