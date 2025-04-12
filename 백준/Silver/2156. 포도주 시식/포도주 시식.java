import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int [] drink = new int[n+1];
		int [] dp = new int[n+1];
		
		for(int i = 1; i<=n; i++) {
			drink[i] = Integer.parseInt(br.readLine());
		}
		
		dp[1] = drink[1];
		if(n>=2) {
		dp[2] = drink[2]+dp[1];
		}
		if(n>=3) {
			dp[3] = Math.max(
					drink[3] + dp[1],
					dp[2]);
			dp[3] = Math.max(dp[3],drink[3]+drink[2]);
		}
		
		if(n>=4) {
			for(int i = 4; i<=n; i++) {
				dp[i] = Math.max(drink[i]+dp[i-2],drink[i]+drink[i-1]+dp[i-3]);
				dp[i] = Math.max(dp[i],dp[i-1]);
			}
		}
		
		System.out.println(dp[n]);
		
		
		
					
		
		bw.flush();
		bw.close();
		
		br.close();		
		
	}
}