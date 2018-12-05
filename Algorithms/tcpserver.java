import java.net.*;
import java.io.*;

public class tcpserver {
	public static void main(String[] args) throws IOException {
		ServerSocket sersock = new ServerSocket(4000);
		System.out.println("Server Ready!");
		Socket sock = sersock.accept();
		System.out.println("Server Connected!");
		
		InputStream istream = sock.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(istream));
		String fname = reader.readLine();
		
		OutputStream ostream = sock.getOutputStream();
		PrintWriter writer = new PrintWriter(ostream, true);
		
		BufferedReader content = new BufferedReader(new FileReader(fname));
		String str;
		
		while((str = content.readLine()) != null) {
			writer.println(str);
		}
		
		writer.close();
		reader.close();
		content.close();
		sock.close();
		sersock.close();
	}
}
