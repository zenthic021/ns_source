import java.io.*;
import java.net.*;

public class ChatServer {

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(6000);

            System.out.println("Chat Server Started");

            Socket socket = server.accept();

            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));

            String msg;

            while ((msg = in.readLine()) != null) {

                System.out.println("Client: " + msg);
            }

            socket.close();
            server.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}