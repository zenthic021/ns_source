import java.util.Scanner;

public class ARP {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String ip = "192.168.1.1";
        String mac = "AA:BB:CC:11";

        System.out.println("1. ARP");
        System.out.println("2. RARP");
        System.out.print("Enter choice: ");

        int ch = sc.nextInt();
        sc.nextLine();

        if (ch == 1) {

            System.out.print("Enter IP Address: ");
            String inputIP = sc.nextLine();

            if (inputIP.equals(ip))
                System.out.println("MAC Address: " + mac);
            else
                System.out.println("Not Found");

        } else if (ch == 2) {

            System.out.print("Enter MAC Address: ");
            String inputMAC = sc.nextLine();

            if (inputMAC.equalsIgnoreCase(mac))
                System.out.println("IP Address: " + ip);
            else
                System.out.println("Not Found");

        } else {
            System.out.println("Invalid Choice");
        }

        sc.close();
    }
}