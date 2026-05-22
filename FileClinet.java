import java.io.*;
import java.net.*;

public class FileClient {

    public static void main(String[] args) {

        try {

            Socket socket =
                    new Socket("localhost", 7000);

            InputStream in =
                    socket.getInputStream();

            FileOutputStream fos =
                    new FileOutputStream("received.txt");

            int data;

            while ((data = in.read()) != -1) {

                fos.write(data);
            }

            fos.close();
            socket.close();

            System.out.println("File Received");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}