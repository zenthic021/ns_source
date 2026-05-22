import java.util.Scanner;

public class HillCipher {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        int[][] key = {
                {3, 3},
                {2, 5}
        };


        int[][] inverseKey = {
                {15, 17},
                {20, 9}
        };

        System.out.print("Enter Plain Text : ");
        String text = sc.nextLine().toUpperCase();

        
        text = text.replaceAll(" ", "");

        
        if (text.length() % 2 != 0) {
            text += "X";
        }

        String encrypted = "";

        
        for (int k = 0; k < text.length(); k += 2) {

            int[] msg = new int[2];
            int[] enc = new int[2];


            for (int i = 0; i < 2; i++) {
                msg[i] = text.charAt(k + i) - 'A';
            }


            for (int i = 0; i < 2; i++) {
                enc[i] = (key[i][0] * msg[0] +
                          key[i][1] * msg[1]) % 26;
            }

            // Convert back to letters
            for (int i = 0; i < 2; i++) {
                encrypted += (char)(enc[i] + 'A');
            }
        }

        System.out.println("Encrypted Text : " + encrypted);

       
        String decrypted = "";

        for (int k = 0; k < encrypted.length(); k += 2) {

            int[] enc = new int[2];
            int[] dec = new int[2];

           
            for (int i = 0; i < 2; i++) {
                enc[i] = encrypted.charAt(k + i) - 'A';
            }


            for (int i = 0; i < 2; i++) {
                dec[i] = (inverseKey[i][0] * enc[0] +
                          inverseKey[i][1] * enc[1]) % 26;
            }


            for (int i = 0; i < 2; i++) {
                decrypted += (char)(dec[i] + 'A');
            }
        }

        System.out.println("Decrypted Text : " + decrypted);
    }
}