import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WebPageDownload {

    public static void main(String[] args) {

        try {

            Scanner sc = new Scanner(System.in);

            // Get website name
            System.out.print("Enter Website Name : ");
            String host = sc.nextLine();

            // Create socket connection
            Socket socket = new Socket(host, 80);

            // Send HTTP GET request
            PrintWriter out =
                    new PrintWriter(socket.getOutputStream(), true);

            out.println("GET / HTTP/1.1");
            out.println("Host: " + host);
            out.println("Connection: Close");
            out.println();

            // Read webpage data
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()));

            // Create file to save webpage
            FileWriter file =
                    new FileWriter("webpage.html");

            String line;

            while ((line = in.readLine()) != null) {

                file.write(line + "\n");
            }

            file.close();
            socket.close();

            System.out.println("Web page downloaded successfully.");
            System.out.println("Saved as webpage.html");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}