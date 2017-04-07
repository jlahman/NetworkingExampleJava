import java.util.List;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
//10.192.145.217
        MockClient mc = new MockClient("127.0.0.1", 4444);
        MockServer ms = new MockServer(4444);
        mc.init();

        Thread sT = new Thread(){
            public void run(){
                ms.init();
                ms.runLoop();
            }
        };

        Thread cT = new Thread(){
            public void run(){
                mc.runLoop();
            }
        };

       // sT.start();
        //cT.start();
        List<MockClient> test = new Vector<MockClient>();


    }
}
