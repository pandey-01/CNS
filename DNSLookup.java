import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class DNSLookup {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter an IP address or hostname:");
        String input = scanner.nextLine();

        if (isIPAddress(input)) {
            // Input is an IP address - get hostname
            try {
                InetAddress inet = InetAddress.getByName(input);
                String hostname = inet.getCanonicalHostName();
                System.out.println("Hostname for IP " + input + " is: " + hostname);
            } catch (UnknownHostException e) {
                System.out.println("Could not resolve hostname for IP: " + input);
            }
        } else {
            // Input is a hostname - get IP address
            try {
                InetAddress inet = InetAddress.getByName(input);
                String ip = inet.getHostAddress();
                System.out.println("IP address for hostname " + input + " is: " + ip);
            } catch (UnknownHostException e) {
                System.out.println("Could not resolve IP address for hostname: " + input);
            }
        }

        scanner.close();
    }

    // Simple check if the input is an IP address
    private static boolean isIPAddress(String input) {
        return input.matches("\\b(?:\\d{1,3}\\.){3}\\d{1,3}\\b");
    }
}
