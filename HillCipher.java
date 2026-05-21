import java.util.Scanner;

public class HillCipher {

    // Encrypt function
    static String encrypt(String message, int[][] keyMatrix) {

        message = message.toUpperCase().replaceAll("\\s", "");

        if (message.length() % 2 != 0) {
            message += "X";
        }

        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < message.length(); i += 2) {

            int a = message.charAt(i) - 'A';
            int b = message.charAt(i + 1) - 'A';

            int c1 = (keyMatrix[0][0] * a + keyMatrix[0][1] * b) % 26;
            int c2 = (keyMatrix[1][0] * a + keyMatrix[1][1] * b) % 26;

            cipherText.append((char) (c1 + 'A'));
            cipherText.append((char) (c2 + 'A'));
        }

        return cipherText.toString();
    }

    // Decrypt function
    static String decrypt(String cipher, int[][] inverseMatrix) {

        StringBuilder plainText = new StringBuilder();

        for (int i = 0; i < cipher.length(); i += 2) {

            int a = cipher.charAt(i) - 'A';
            int b = cipher.charAt(i + 1) - 'A';

            int p1 = (inverseMatrix[0][0] * a + inverseMatrix[0][1] * b) % 26;
            int p2 = (inverseMatrix[1][0] * a + inverseMatrix[1][1] * b) % 26;

            if (p1 < 0) p1 += 26;
            if (p2 < 0) p2 += 26;

            plainText.append((char) (p1 + 'A'));
            plainText.append((char) (p2 + 'A'));
        }

        return plainText.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] keyMatrix = {
                {3, 3},
                {2, 5}
        };

        // Inverse matrix of above key matrix
        int[][] inverseMatrix = {
                {15, 17},
                {20, 9}
        };

        System.out.print("Enter the message: ");
        String message = sc.nextLine();

        String encrypted = encrypt(message, keyMatrix);
        System.out.println("Encrypted Text: " + encrypted);

        String decrypted = decrypt(encrypted, inverseMatrix);
        System.out.println("Decrypted Text: " + decrypted);

        sc.close();
    }
}