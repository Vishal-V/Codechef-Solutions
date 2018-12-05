import java.util.*;

public class bellmanford {
	private int N;
	private int[] D;
	private static int MAX_VAL = 999;
	
	public bellmanford(int n) {
		this.N= n;
		this.D = new int[n+1];
	}
	
	public void bellman(int s, int[][] a) {
		for(int i=1;i<=N;i++)
			D[i] = MAX_VAL;
		D[s] = 0;
		for(int k=1;k<=N-1;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(a[i][j] != MAX_VAL) {
						if(D[j] > D[i] + a[i][j])
							D[j] = D[i] + a[i][j];
					}
				}
			}
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				if(a[i][j] != MAX_VAL) {
					if(D[j] > D[i] + a[i][j]) {
						System.out.println("There exists a Negative edge cycle!");
						return;
					}
				}
			}
		}
		for(int i=1;i<=N;i++)
			System.out.println("Distance from " + s + " to " + i + " is " + D[i]);
	}
	
	public static void main(String[] args) {
		int a[][] = new int[10][10];
		int s, n;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of vertices: ");
		n = in.nextInt();
		System.out.println("Enter the source: ");
		s = in.nextInt();

		System.out.println("Enter the cost matrix: ");
		for(int i=1;i<=n;i++)
			for(int j=1;j<=n;j++) {
				a[i][j] = in.nextInt();
				if( i == j )
					a[i][j] = 0;
			}
		bellmanford bf =new bellmanford(n);
		bf.bellman(s, a);
		in.close();
	}
}
