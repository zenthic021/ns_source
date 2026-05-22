import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ChatClient {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost", 6000);

            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.print("Enter Message: ");

                String msg = sc.nextLine();

                out.println(msg);

                if (msg.equalsIgnoreCase("bye"))
                    break;
            }

            socket.close();

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}