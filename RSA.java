import java.math.BigInteger;
import java.util.Scanner;

public class RSA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        
        System.out.print("Enter first prime number (p): ");
        BigInteger p = sc.nextBigInteger();

        System.out.print("Enter second prime number (q): ");
        BigInteger q = sc.nextBigInteger();


        BigInteger n = p.multiply(q);

        
        BigInteger phi = (p.subtract(BigInteger.ONE))
                .multiply(q.subtract(BigInteger.ONE));

       
        System.out.print("Enter public key (e): ");
        BigInteger e = sc.nextBigInteger();


        BigInteger d = e.modInverse(phi);

        
        System.out.print("Enter message value: ");
        BigInteger message = sc.nextBigInteger();

       
        BigInteger cipher = message.modPow(e, n);

        
        BigInteger decrypted = cipher.modPow(d, n);

        
        System.out.println("\n----- RSA Algorithm -----");
        System.out.println("Value of n = " + n);
        System.out.println("Value of phi = " + phi);
        System.out.println("Private key (d) = " + d);

        System.out.println("\nOriginal Message = " + message);
        System.out.println("Encrypted Message = " + cipher);
        System.out.println("Decrypted Message = " + decrypted);

        sc.close();
    }
}