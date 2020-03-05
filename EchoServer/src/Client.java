import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public abstract class Client extends Thread{

    protected static String ipAddress;
    protected static int serverPort;
    protected static Socket socket;


    protected abstract String[] receiveCommand();

    protected abstract boolean validateCommandFormat(String[] commandParts);






}
