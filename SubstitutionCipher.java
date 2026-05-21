import java.util.Scanner;

public class SubstitutionCipher {

    // Method for encryption
    public static String encrypt(String text, int key) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {

            if (Character.isUpperCase(ch)) {
                char c = (char) (((ch - 'A' + key) % 26) + 'A');
                result.append(c);
            }

            else if (Character.isLowerCase(ch)) {
                char c = (char) (((ch - 'a' + key) % 26) + 'a');
                result.append(c);
            }

            else {
                result.append(ch);
            }
        }

        return result.toString();
    }

    // Method for decryption
    public static String decrypt(String text, int key) {
        return encrypt(text, 26 - key);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the plain text: ");
        String plainText = sc.nextLine();

        System.out.print("Enter the key value: ");
        int key = sc.nextInt();

        String encrypted = encrypt(plainText, key);
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = decrypt(encrypted, key);
        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}