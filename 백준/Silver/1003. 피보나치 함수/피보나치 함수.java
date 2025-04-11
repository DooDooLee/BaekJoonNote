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
			int [][] dp = new int[n+1][2];
			dp[0][0]=1;
			dp[0][1]=0;
			if(n>=1) {
				dp[1][0]=0;
				dp[1][1]=1;
			}
			if(n>1) {
				for(int i = 2; i<=n; i++) {
					dp[i][0] = dp[i-1][0]+dp[i-2][0];
					dp[i][1] = dp[i-1][1]+dp[i-2][1];
				}
			}
			sb.append(String.valueOf(dp[n][0])+" "+String.valueOf(dp[n][1])+"\n");	
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();		
		
	}
}