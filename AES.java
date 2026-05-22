import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class AES {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

     
        System.out.print("Enter the plain text: ");
        String message = sc.nextLine();

       
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();

       
        Cipher cipher = Cipher.getInstance("AES");


        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());

        String encryptedText =
                Base64.getEncoder().encodeToString(encryptedBytes);

        
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes =
                cipher.doFinal(Base64.getDecoder().decode(encryptedText));

        String decryptedText = new String(decryptedBytes);

        
        System.out.println("\n----- Symmetric Key Algorithm (AES) -----");

        System.out.println("Original Text : " + message);
        System.out.println("Encrypted Text: " + encryptedText);
        System.out.println("Decrypted Text: " + decryptedText);

        sc.close();
    }
}