import java.util.Scanner;

public class crc {
	public void divide(int[] a, int k) {
		int gp[] = {1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
		int source = 0;
		for(int i=0;i<k;i++) {
			if(a[i] == gp[0]) {
				for(int j=i;j<17+i;j++) {
					a[j] = a[j] ^ gp[source++];
				}
				source = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int a[] = new int[50];
		int b[] = new int[50];
		int k, len, flag = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the size of message: ");
		len = in.nextInt();
		int i;
		System.out.println("Enter the message: ");
		for(i=0;i<len;i++)
			a[i] = in.nextInt();
		
		for(i=0;i<16;i++)
			a[len++] = 0;
		k = len-16;
		for(i=0;i<len;i++)
			b[i] = a[i];
		
		crc c = new crc();
		c.divide(a, k);
		
		for(i=0;i<len;i++)
			a[i] = a[i] ^ b[i];
		
		System.out.println("Message to be transmitted: ");
		for(i=0;i<len;i++)
			System.out.print(a[i] + " ");
		
		System.out.println("\nEnter the received message: ");
		for(i=0;i<len;i++)
			a[i] = in.nextInt();
		
		c.divide(a, k);
		
		for(i=0;i<len;i++) {
			if(a[i] != 0) {
				flag = 1;
				break;
			}
		}
		in.close();
		
		if(flag == 1)
			System.out.println("Error!");
		else
			System.out.println("No error!");
	}
}
