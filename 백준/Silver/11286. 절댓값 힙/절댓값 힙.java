
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Queue<Integer> pq = new PriorityQueue<>((x,y) -> {
			int ax = Math.abs(x);
			int ay = Math.abs(y);
			
			if(ax == ay) {
				return x-y;
			}
			return ax-ay;
			
			
			
			
		});
		
		
		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(br.readLine());
			if(x==0) {
				if(pq.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(pq.poll());
				}
			}else{
				pq.add(x);
			}
		}
		
	}
}
