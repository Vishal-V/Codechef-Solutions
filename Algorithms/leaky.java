import java.util.*;

public class leaky {
	public static void main(String[] args) {
		int bucket_size, no_groups;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the bucket size: ");
		bucket_size = in.nextInt();
		System.out.println("Enter the no: of groups: ");
		no_groups = in.nextInt();
		int[] in_bw = new int[50];
		int[] no_packets = new int[50];
		int tot_pkts = 0, reqd_bw = 0;
		for(int i=0;i<no_groups;i++) {
			System.out.println("Enter the no: of packets: ");
			no_packets[i] = in.nextInt();
			System.out.println("Enter the input bandwidth: ");
			in_bw[i] = in.nextInt();
			if((tot_pkts + no_packets[i]) < bucket_size)
				tot_pkts += no_packets[i];
			else {
				do {
					System.out.println("Bucket Overflow\nEnter no: of packets lesser than: "+(bucket_size-tot_pkts));
					no_packets[i] = in.nextInt();
				}while((tot_pkts + no_packets[i]) > bucket_size);
				tot_pkts += no_packets[i];
			}
			reqd_bw += (no_packets[i] * in_bw[i]);
		}
		System.out.println("Enter the output bandwidth: ");
		int out_bw = in.nextInt();
		int temp = reqd_bw;
		int rem_pkts = tot_pkts;
		
		while((out_bw <= temp) && rem_pkts > 0) {
			System.out.println("There are "+(--rem_pkts)+" packets remaining\nThe remaining bw is: " +
				(temp -= out_bw));
			if((out_bw > temp) && rem_pkts > 0)
				System.out.println(rem_pkts + " Number of packets dropped!");
					
		}
		in.close();
	}
}
