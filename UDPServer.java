package udp;
import java.io.*;
import java.net.*;
public class UDPServer {
	static final int BUFFERSIZE = 256;
	public static void main(String[] args) throws Exception{
		DatagramSocket serverSocket = new DatagramSocket(9876);
		DatagramPacket pack = new DatagramPacket(new byte[BUFFERSIZE],BUFFERSIZE);
		while(true)
        {
           serverSocket.receive(pack);
           String sentence = new String( pack.getData(),0,pack.getLength());
           System.out.println("RECEIVED: " + sentence);
           
        }
		
	}
}
