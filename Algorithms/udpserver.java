import java.net.*;
import java.io.*;

public class udpserver {
	public static void main(String[] args) throws IOException {
		DatagramSocket skt;
		
		try {
			skt = new DatagramSocket(6788);
			byte b[] = new byte[100];
			
			while(true) {
				DatagramPacket request = new DatagramPacket(b, b.length);
				skt.receive(request);
				System.out.println("Request packet received!");
				String msg = new String(request.getData()).replaceAll("[^0-9A-za-z ]", "");
				System.out.println(msg);
				
				byte[] buffer = new byte[100];
				buffer = "Server Communicated".getBytes();
				DatagramPacket response = new DatagramPacket(buffer, buffer.length, request.getAddress(), request.getPort());
				skt.send(response);
				System.out.println("Response packet sent!");
			}
		}catch(Exception e) {}
	}
}
