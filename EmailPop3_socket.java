import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Base64;
import java.util.Scanner;
// import javax.mail.*;
/* import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory; */

public class EmailPop3_socket {

    private String host;
    private int port;
    private String user;
    private String password;
    private Socket socket;
    private BufferedReader reader;
    private PrintWriter writer;

    public EmailPop3_socket(String host, Integer port, String user, String password) {
        this.host=host;
        this.port=port;
        this.user=user;
        this.password=password;
    }

    public void buildEmailConnection() {
        try {
            Socket socket = new Socket(host, port);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

            String response = reader.readLine();
            if (!response.startsWith("+OK")) {
                throw new RuntimeException("Error connecting to POP3 server");
            }

            // send user command
            writer.println("USER " + user);
            writer.flush();
            response = reader.readLine();
            if (!response.startsWith("+OK")) {
                throw new RuntimeException("Error authenticating with POP3 server1");
            }

            // send password command
            String encodedPassword = password;
            writer.println("PASS " + encodedPassword);
            writer.flush();
            response = reader.readLine();
            if (!response.startsWith("+OK")) {
                throw new RuntimeException("Error authenticating with POP3 server2");
            }
            // get message count
            writer.println("STAT");
            writer.flush();
            response = reader.readLine();
            if (!response.startsWith("+OK")) {
                throw new RuntimeException("Error getting message count from POP3 server");
            }
            String[] status = response.split(" ");
            int messageCount = Integer.parseInt(status[1]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void closeEmailConnection() {
        try {
            writer.println("QUIT");
            writer.flush();
            reader.close();

            writer.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
    public void retrieveEmails() {
        Scanner input = new Scanner(System.in);
        EmailRetriever emailRetriever = new EmailRetriever(reader, writer);
        emailRetriever.retrieveEmails();
        System.out.println("Enter your desired Email u want to let us schow to u: ");
        String emailnumber = input.nextLine();
        try{
            emailRetriever.retrieveEmailContent(Integer.parseInt(emailnumber));
            while (!emailnumber.equals(null)){
                System.out.println("Enter your desired Email u want to let us schow to u: ");
                String email_number = input.nextLine();
                emailRetriever.retrieveEmailContent(Integer.parseInt(email_number));

            }
        }
        catch(NumberFormatException e)
        {
        }
        //emailRetriever.retrieveEmailContent(Integer.parseInt(emailnumber));
        input.close();
    }
   /*  public class EmailCredentialsExample {
        public static void main(String[] args) {
            EmailCredentialsInput input = new EmailCredentialsInput();3
            input.getUserInput();
    
            String host = input.getHost();
            int port = input.getPort();
            String username = input.getUsername();
            String password = input.getPassword();
    
            EmailPop3_socket emailClient = new EmailPop3_socket(host, port, username, password);
            emailClient.buildEmailConnection();
            emailClient.retrieveEmails();
            // emailClient.closeEmailConnection();
        }
    } */
    
     public static void main(String[] args) {
        EmailCredentialsInput input = new EmailCredentialsInput();
        input.getUserInput();

        String host = input.getHost();
        Integer port = input.getPort();
        String username = input.getUsername();
        String password = input.getPassword();

        EmailPop3_socket emailClient = new EmailPop3_socket(host, port, username, password);
        emailClient.buildEmailConnection();
        emailClient.retrieveEmails();
        
        // emailClient.closeEmailConnection()
    }
     /* public static void main(String[] args) {
       /*  EmailCredentialsInput input = new EmailCredentialsInput();
        input.getUserInput(); */
       /*  Scanner input = new Scanner(System.in);
            System.out.print("Enter the POP3 host: ");
            String host = input.nextLine();
            System.out.print("Enter the POP3 port: ");
            int port = input.nextInt();
            input.nextLine(); // Consume the newline character
            System.out.print("Enter your username: ");
            String username = input.nextLine();;
            System.out.print("Enter your password: ");
            String password = input.nextLine();



        EmailPop3_socket emailClient = new EmailPop3_socket(host, port, username, password);
        emailClient.buildEmailConnection();
        emailClient.retrieveEmails();
        // emailClient.closeEmailConnection()
    }  */ 

}    

       


