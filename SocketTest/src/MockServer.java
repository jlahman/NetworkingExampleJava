import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by madashi on 4/6/17.
 */
public class MockServer {
    private int portNumber;
    private ServerSocket sSocket;
    private Socket cSocket;
    private PrintWriter out;
    private BufferedReader in;

    public MockServer(){

    }

    public MockServer(int portnumber){
        this.portNumber = portnumber;
        try {
            sSocket = new ServerSocket(portNumber);
        } catch (IOException e) {

        }
    }

    public void init(){
        try{
            cSocket = sSocket.accept();
            out = new PrintWriter(cSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(cSocket.getInputStream()));
        } catch (Exception e){
            System.err.println("Error occured: " + e.getMessage());
        }
    }

    public void runLoop(){
        String fromClient = "", sMessage;
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        sMessage = "HI!";
        try{
            while (sMessage  != "quit"){//&& fromClient != null) {
                System.out.println("Server: " + sMessage);
                out.println(sMessage);

                fromClient = in.readLine();
                sMessage = "Message Received: " +  fromClient;
                System.out.println(sMessage);

            }
        }
        catch (Exception e){

        }
    }


}
