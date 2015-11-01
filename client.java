package udp;
import java.io.*;
import java.net.*;
import java.util.*;

public class client{
	static final int BUFFERSIZE = 256;
	public static int x = 0;
	public static int y = 0;
	public static void main(String args[]) throws Exception {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter two computer's IP address :");
		String ip1 = input.next();
		String ip2 = input.next();
		DatagramSocket clientSocket = new DatagramSocket();
		InetAddress IPAddress = InetAddress.getByName("localhost");
		LocationChange();
		SendLocation(clientSocket, IPAddress);
		while(true){
		}
	}
	public static void LocationChange(){
		Timer t = new Timer();
		t.schedule(new TimerTask(){

			@Override
			public void run() {
				x = (x + 1) % 100;
				y = (y + 1) % 100;
			}
			
		},0,2000);
	}
	public static void SendLocation(DatagramSocket client, InetAddress ip) throws IOException{
		Timer t = new Timer();
		t.schedule(new TimerTask(){

			@Override
			public void run() {
				String location = x + " " + y;
				byte[] sendData = location.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, ip, 9876);
				try {
					client.send(sendPacket);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		},0,200);
		
	}
	
}
