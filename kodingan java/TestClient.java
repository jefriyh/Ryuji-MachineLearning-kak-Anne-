
// File Name ClientTest.java
import java.net.*;
import java.io.*;

public class TestClient {

   public static void main(String [] args) throws IOException {

   		if (args.length != 2) {
   			System.err.println( "Usage: java EchoClient <host name> <port number>" );
   			System.exit(1);
   		}

   		String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
            Socket echoSocket 		= new Socket(hostName, portNumber);
            PrintWriter out 		= new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in 		= new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn 	= new BufferedReader(new InputStreamReader(System.in));
        ) {

            String userInput;

            do{
            	System.out.print("msg: ");
            	userInput = stdIn.readLine();
                out.println(userInput);

                System.out.println("SERVER: " + in.readLine());
            } while (userInput != null);

        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);

        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " + hostName);
            System.exit(1);

        } 

   }
}