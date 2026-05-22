import java.math.BigInteger;
import java.util.Scanner;

public class DH {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the prime number (p):");
        BigInteger p = sc.nextBigInteger();

        System.out.println("Enter the primitive root (g):");
        BigInteger g = sc.nextBigInteger();

        System.out.println("Enter private key of User A:");
        BigInteger a = sc.nextBigInteger();

        System.out.println("Enter the private key of User B:");
        BigInteger b = sc.nextBigInteger();

        
        BigInteger A = g.modPow(a, p);
        BigInteger B = g.modPow(b, p);

        
        BigInteger keyA = B.modPow(a, p);
        BigInteger keyB = A.modPow(b, p);

        System.out.println("Public key of User A: " + A);
        System.out.println("Public key of User B: " + B);

        System.out.println("Secret key of User A: " + keyA);
        System.out.println("Secret key of User B: " + keyB);

        sc.close();
    }
}