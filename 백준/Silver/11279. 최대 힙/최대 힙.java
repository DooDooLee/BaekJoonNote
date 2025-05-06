
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Queue<Integer> pq = new PriorityQueue<>((x,y)->{
			return y-x;
		});
		
		for(int i =0; i<n; i++) {
			int a =  Integer.parseInt(br.readLine());
			if(a==0 ) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}
			else {
				pq.add(a);
			}
			
			
		}
		
		
		
	}
}
