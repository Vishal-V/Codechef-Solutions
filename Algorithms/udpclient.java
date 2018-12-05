import java.net.*;
import java.io.*;

public class udpclient {
	public static void main(String[] args) throws IOException {
		DatagramSocket sock;
		try {
			
			sock = new DatagramSocket();
			byte[] b = new byte[100];
			String msg = "UDP is awesome!";
			b = msg.getBytes();
			InetAddress host = InetAddress.getByName("127.0.0.1");
			int serversocket = 6788;
			DatagramPacket request = new DatagramPacket(b, b.length, host, serversocket);
			sock.send(request);
			
			byte[] buffer = new byte[100];
			DatagramPacket response = new DatagramPacket(buffer, buffer.length);
			sock.receive(response);
			
			String message = new String(response.getData());
			System.out.println(message);
			sock.close();
			
		}catch(Exception e) {}
	}
}
