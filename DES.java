import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.KeyGenerator;
import java.util.Base64;
import java.util.Scanner;

public class DES {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

       
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecretKey key = keyGen.generateKey();

        
        Cipher desCipher = Cipher.getInstance("DES");

        
        System.out.print("Enter Plain Text : ");
        String text = sc.nextLine();

        
        desCipher.init(Cipher.ENCRYPT_MODE, key);

        byte[] textBytes = text.getBytes();

        byte[] encryptedBytes = desCipher.doFinal(textBytes);

        String encryptedText =
                Base64.getEncoder().encodeToString(encryptedBytes);

        System.out.println("Encrypted Text : " + encryptedText);

        
        desCipher.init(Cipher.DECRYPT_MODE, key);

        byte[] decryptedBytes =
                desCipher.doFinal(encryptedBytes);

        String decryptedText =
                new String(decryptedBytes);

        System.out.println("Decrypted Text : " + decryptedText);
    }
}