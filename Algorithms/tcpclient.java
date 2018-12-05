import java.io.IOException;
import java.net.*;
import java.io.*;

public class tcpclient {
	public static void main(String[] args) throws IOException {
		Socket sock = new Socket("127.0.0.1", 4000);
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the filename: ");
		String fname = reader.readLine();
		
		OutputStream ostream = sock.getOutputStream();
		PrintWriter writer = new PrintWriter(ostream, true);
		writer.println(fname);
		
		InputStream istream = sock.getInputStream();
		reader = new BufferedReader(new InputStreamReader(istream));
		String str;
		
		while((str = reader.readLine()) != null){
			System.out.print(str);
		}
		
		writer.close();
		reader.close();
		sock.close();
		
	}
}
