/* import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class EmailCredentialsInput {
    private String host;
    private int port;
    private String username;
    private String password;

    public void getUserInput() {
        Scanner scanner = new Scanner(System.in);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println("Enter the POP3 host:");
            host = scanner.nextLine();
            System.out.println("Enter the POP3 port:");
            port = Integer.parseInt(reader.readLine());
            System.out.println("Enter your username:");
            username = reader.readLine();
            System.out.println("Enter your password:");
            password = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
 */

 import java.util.Scanner;

public class EmailCredentialsInput {
    public String host;
    public Integer port;
    public String username;
    public String password;

    public void getUserInput() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.print("Enter the POP3 host: ");
            this.host = input.nextLine();
            System.out.print("Enter the POP3 port: ");
            this.port = Integer.parseInt(input.nextLine());
            
            //input.nextLine(); // Consume the newline character
            System.out.print("Enter your username: ");
            this.username = input.nextLine();
            System.out.print("Enter your password: ");
            this.password = input.nextLine();

            // input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getHost() {
        return this.host;
    }

    public int getPort() {
        return this.port;
    }

    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}

