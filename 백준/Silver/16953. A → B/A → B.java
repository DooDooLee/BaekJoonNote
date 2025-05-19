import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		
		long a = Long.parseLong(st.nextToken());
		long b =  Long.parseLong(st.nextToken());
		long result = Long.MAX_VALUE;
		
		Queue <long []> q = new LinkedList<>();
		q.add(new long[] {a,0L});
		
		while(!q.isEmpty()) {
			long [] temp = q.poll();
			long x = temp[0];
			long depth = temp[1];
			
			if(x == b) {
				result = depth;
				break;
			}
			
			if(x * 2 <= b) {
				q.add(new long[] {x * 2, depth + 1});
			}	
			
			String as = String.valueOf(x) + "1";
			if(Long.parseLong(as) <= b) {
				q.add(new long[] {Long.parseLong(as), depth + 1});
			}
		}
		
		if(result == Long.MAX_VALUE) {
			result = -1L;
		} else {
			result++;
		}
		
		System.out.println(result);
	}
}
