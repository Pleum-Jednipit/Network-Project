import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Publisher extends Client{



    public static void main(String[] args)
    {
        Publisher publisher = new Publisher();
        publisher.receiveCommand();
        while(true){
            publisher.receiveCommand();
            try (Socket socket = new Socket("localhost", 5000)) {

            } catch(SocketTimeoutException e) {
                System.out.println("The socket timed out");
            } catch (IOException e) {
                System.out.println("Client Error: " + e.getMessage());

            }
        }
//        String[] fields;
//        while(true)
//        {
//            do
//            {
//                /* Get command from user */
//                fields = getCommand();
//                if(fields[0].equals("exit"))
//                {
//                    System.out.println("Good bye");
//                    System.exit(0);
//                }
//                else
//                    ipAddress = fields[1];
//
//                try
//                {
//                    server = new Socket(ip, port);
//                    //				server.setSoTimeout(30000);
//                }
//                catch (IOException e)
//                {
//                    System.out.println("Cannot connect the server");
//                    System.out.println("Please try again");
//                }
//
//                if(server != null)
//                {
//                    System.out.println("Just connected to " + server.getRemoteSocketAddress());
//                }
//            } while(server == null);
//
//
//            DataOutputStream out = new DataOutputStream(server.getOutputStream());
//            out.writeUTF(fields[0] + " " + fields[2] + " " + fields[3]);
//            server.close();
//            System.out.println("The message has sent already\n");
//        }
    }

    @Override
    protected String[] receiveCommand() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is Publisher client, Please enter the command according to the following format");
        System.out.println("publish 'broker_ip_address' 'topic_name' 'data to publish' ");
        System.out.println("Enter quit to exit");
        String command = scanner.nextLine();
        String[] commandParts = command.split(" ");
        if(validateCommandFormat(commandParts)){
            System.out.println("True");
        } else {
            System.out.println("False");
        }
        return commandParts;
    }

    @Override
    protected boolean validateCommandFormat(String[] commandParts) {
        if(commandParts.length != 4){
            return false;
        } else if(!commandParts[0].equals("publish")){
            return false;
        } else if(commandParts[1].isEmpty()){
            return false;
        } else if(commandParts[2].isEmpty()){
            return false;
        } else {
            return true;
        }
    }
}
