import java.security.MessageDigest;
import java.util.Scanner;

public class MD5 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Text : ");
        String text = sc.nextLine();


        MessageDigest md = MessageDigest.getInstance("MD5");


        md.update(text.getBytes());

        
        byte[] digest = md.digest();


        StringBuilder sb = new StringBuilder();

        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }

       
        System.out.println("Message Digest : " + sb.toString());
    }
}