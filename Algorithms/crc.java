package crc;
import java.util.*;

class crc{
	void div(int a[], int k) {
		int count = 0;
		int gp[] = {1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,1};
		for(int i=0;i<k;i++) {
			if(a[i] == gp[0]) {
				for(int j=i;j<17+i;j++)
					a[j] = a[j] ^ gp[count++];
				count = 0;
			}
		}
	}
	
	public static void main(String[] args) {
		int a[] = new int[100];
		int b[] = new int[100];
		int k,len,flag=0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size: ");
		len = sc.nextInt();
		System.out.println("Enter the message: ");
		for(int i=0;i<len;i++)
			a[i] = sc.nextInt();
		for(int i=0;i<16;i++)
			a[len++] = 0;
		k =len-16;
		for(int i=0;i<len;i++)
			a[i] = b[i];
		crc orb = new crc();
		orb.div(a, k);
		for(int i=0;i<len;i++)
			a[i] = a[i] ^ b[i];
		System.out.println("Enter the received message: ");
		for(int i=0;i<len;i++)
			a[i] = sc.nextInt();
		orb.div(a, k);
		for(int i=0;i<len;i++) {
			if(a[i] != 0) {
				flag = 1;
				break;
			}
		}
		if(flag==1)
			System.out.println("Error ");
		else
			System.out.println("No error");
	}
}