/* import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;

public class EmailRetriever {
    private BufferedReader reader;
    private PrintWriter writer;

    public EmailRetriever(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    public void retrieveEmails() {
        try {
            // get message list
            writer.println("LIST");
            writer.flush();
            String response = reader.readLine();
            while (!response.equals(".")) {
                System.out.println(response);
                response = reader.readLine();
            }

            // get message content
            for (int i = 1; i <= 5; i++) {
                writer.println("RETR " + i);
                writer.flush();
                response = reader.readLine();
                while (!response.equals(".")) {
                    System.out.println(response);
                    response = reader.readLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class EmailRetriever {
    private BufferedReader reader;
    private PrintWriter writer;
    private int emailCount;

    public EmailRetriever(BufferedReader reader, PrintWriter writer) {
        this.reader = reader;
        this.writer = writer;
        this.emailCount = 0;
    }

    public void retrieveEmails() {
        try {
            // get message list
            writer.println("LIST");
            writer.flush();
            String response = reader.readLine();
            while (!response.equals(".")) {
                response = reader.readLine();
                emailCount++; // Increment the email count for each message
            }
            System.out.println(response);

          /*   // get message content
            for (int i = 1; i <= 5; i++) {
                writer.println("RETR " + i);
                writer.flush();
                response = reader.readLine();
                while (!response.equals(".")) {
                    System.out.println(response);
                    response = reader.readLine();
                }
            } */

            System.out.println("Total Emails: " + emailCount); // Display the total email count
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void retrieveEmailContent(int emailNumber) {
        try {
            writer.println("RETR " + emailNumber);
            writer.flush();
            String response = reader.readLine();
            while (!response.equals(".")) {
                System.out.println(response);
                response = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
