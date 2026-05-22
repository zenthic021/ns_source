import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.util.Base64;
import java.util.Scanner;

public class TripleDES {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter Plain Text : ");
        String plainText = sc.nextLine();

       
        KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
        SecretKey secretKey = keyGen.generateKey();

       
        Cipher cipher = Cipher.getInstance("DESede");

      
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        byte[] encryptedBytes =
                cipher.doFinal(plainText.getBytes());

        
        String encryptedText =
                Base64.getEncoder().encodeToString(encryptedBytes);

        
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedBytes =
                cipher.doFinal(encryptedBytes);

        String decryptedText =
                new String(decryptedBytes);

        
        System.out.println("\nOriginal Text  : " + plainText);
        System.out.println("Encrypted Text : " + encryptedText);
        System.out.println("Decrypted Text : " + decryptedText);

        sc.close();
    }
}