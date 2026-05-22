import java.security.MessageDigest;
import java.util.Scanner;

public class SHA1 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

       
        System.out.print("Enter Text : ");
        String text = sc.nextLine();

        MessageDigest md = MessageDigest.getInstance("SHA-1");

        
        byte[] messageDigest = md.digest(text.getBytes());


        StringBuilder sb = new StringBuilder();

        for (byte b : messageDigest) {
            sb.append(String.format("%02x", b));
        }

       
        System.out.println("Message Digest (SHA-1) : " + sb.toString());

        sc.close();
    }
}