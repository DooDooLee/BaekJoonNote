import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		while(t-- >0) {
			int n = Integer.parseInt(br.readLine());
			int [] dp = new int[n+1];
			dp[1] = 1;
			if(n>=2) {
				dp[2] =2;
			}
			if(n>=3) {
				dp[3]=4;
			}
			if(n>=4) {
				for(int i = 4; i<=n; i++) {
					dp[i] = dp[i-3]+dp[i-2]+dp[i-1];
				}
			}
			
			sb.append(String.valueOf(dp[n])+"\n");	
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		br.close();		
		
	}
}