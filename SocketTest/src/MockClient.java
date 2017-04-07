import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by madashi on 4/6/17.
 */
public class MockClient {
    private String hostName;
    private int portNumber;
    private Socket mSocket;
    private PrintWriter out;
    private BufferedReader in;

    public MockClient(){

    }

    public MockClient(String hostname, int portnumber){
        this.hostName = hostname;
        this.portNumber = portnumber;
    }

    public void init(){
        try{
            mSocket = new Socket(hostName, portNumber);
            out = new PrintWriter(mSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
        } catch (Exception e){
            System.err.println("Error occured: " + e.getMessage());
        }
    }

    public void init(String hostname, int portnumber){
        this.hostName = hostname;
        this.portNumber = portnumber;

        try{
            mSocket = new Socket(hostName, portNumber);
            out = new PrintWriter(mSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(mSocket.getInputStream()));
        } catch (Exception e){
            System.err.println("Error occured: " + e.getMessage());
        }
    }

    public void runLoop(){
        String fromServer, fromUser;
        BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

        try {


            while (true) {
                fromServer = in.readLine();
                System.out.println("Server(from c): " + fromServer);
                if (fromServer == "quit")
                    break;

                fromUser = stdIn.readLine();

                if (fromUser != null) {
                    System.out.println("Client: " + fromUser);
                    out.println(fromUser);
                }
            }
        } catch(Exception e){

        }
    }
}
