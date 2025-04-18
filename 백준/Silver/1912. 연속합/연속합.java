
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int [] dp =  new int [n+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int [] value = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=n; i++) {
			if(dp[i-1]>0) {
				dp[i] = dp[i-1] + value[i];
			}else {
				dp[i] = value[i];
			}
			
		}
		
		
		int max = dp[1];
		
		for(int i = 2; i<=n; i++) {
			if(max<dp[i]) {
				max = dp[i];
			}
		}
		
		
		System.out.println(max);		
		
	
		br.close();		
		
	}
}