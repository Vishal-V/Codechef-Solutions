package crc;
import java.net.*;
import java.io.*;

public class server {
	public static void main(String[] args) throws IOException {
		ServerSocket sersock = new ServerSocket(4000);
		System.out.println("Server ready!");
		Socket sock = sersock.accept();
		System.out.println("Connection successful!");
		InputStream istream = sock.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
		String fname = reader.readLine();
		OutputStream ostream = sock.getOutputStream();
		PrintWriter writer = new PrintWriter(ostream, true);
		BufferedReader contentread = new BufferedReader(new FileReader(fname));
		String str;
		
		while((str = contentread.readLine()) != null)
			writer.print(str);
		
		writer.close();
		reader.close();
		contentread.close();
		sock.close();
	}
}
