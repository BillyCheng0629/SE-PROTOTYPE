package udp;
import java.io.*;
import java.net.*;
import java.util.*;

public class client extends TimerTask{
	static final int BUFFERSIZE = 256;
	public static int x = 0;
	public static int y = 0;
	public static void main(String args[]) throws Exception {
		Timer timer = new Timer();
		String location = "";
		byte[] sendData  = new byte[256];
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		while(true){
			location = x + " " + y;
			sendData = location.getBytes();
			DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
			clientSocket.send(sendPacket);
			x++;
			y++;
			if(x == 100 || y == 100){
				x = 0;
				y = 0;
			}
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
