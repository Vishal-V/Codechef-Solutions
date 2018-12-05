import java.util.*;
import java.io.*;
import java.math.BigInteger;

class rsa{
	private BigInteger p,q,phi,N,e,d;
	private int bitLength = 1024;
	private Random r;
	
	public rsa() {
		r = new Random();
		p = BigInteger.probablePrime(bitLength, r);
		q = BigInteger.probablePrime(bitLength, r);
		N = p.multiply(q);
		
		phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
		e = BigInteger.probablePrime(bitLength/2, r);
		
		while(phi.gcd(e).compareTo(BigInteger.ONE) > 0 && e.compareTo(phi) < 0)
			e.add(BigInteger.ONE);
		
		d = e.modInverse(phi);
		
	}
	
	public static void main(String[] args) throws IOException{
		DataInputStream dis = new DataInputStream(System.in);
		rsa asr = new rsa();
		System.out.println("Enter the message: ");
		@SuppressWarnings("deprecation")
		String message = dis.readLine();
		byte[] cipher = asr.encrypt(message.getBytes());
		System.out.println("The encrypted String is: " + bytesToString(cipher));
		byte[] decrypted = asr.decrypt(cipher);
		System.out.println("The decrypted String is: " + new String(decrypted));
	}
	public static String bytesToString(byte[] a) {
		String str = "";
		for(byte b : a) str += Byte.toString(b);
		return str;
	}
	
	public byte[] encrypt(byte[] msg) {
		return (new BigInteger(msg).modPow(e, N).toByteArray());
	}
	public byte[] decrypt(byte[] dec) {
		return (new BigInteger(dec).modPow(d, N).toByteArray());
	}
}