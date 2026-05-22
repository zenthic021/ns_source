import java.io.*;
import java.net.*;

public class FileServer {

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(7000);

            System.out.println("Server Waiting...");

            Socket socket = server.accept();

            FileInputStream fis =
                    new FileInputStream("sample.txt");

            OutputStream out = socket.getOutputStream();

            int data;

            while ((data = fis.read()) != -1) {

                out.write(data);
            }

            fis.close();
            socket.close();
            server.close();

            System.out.println("File Sent");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}