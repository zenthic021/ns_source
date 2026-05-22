import java.util.Scanner;

public class SubstitutionCipher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String normal = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String cipher = "QWERTYUIOPASDFGHJKLZXCVBNM";

        System.out.print("Enter Plain Text : ");
        String text = sc.nextLine().toUpperCase();

        String encrypted = "";
        String decrypted = "";

        // Encryption
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            int index = normal.indexOf(ch);

            if (index != -1)
                encrypted += cipher.charAt(index);
            else
                encrypted += ch;
        }

        System.out.println("Encrypted Text : " + encrypted);

        // Decryption
        for (int i = 0; i < encrypted.length(); i++) {
            char ch = encrypted.charAt(i);

            int index = cipher.indexOf(ch);

            if (index != -1)
                decrypted += normal.charAt(index);
            else
                decrypted += ch;
        }

        System.out.println("Decrypted Text : " + decrypted);
    }
}
