import java.util.*;
import java.io.*;
public class Main {
public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n  = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [][] dp = new int [n+1][k+1];
		for(int j =1; j<=k; j++) {
			dp[0][j]=k+1;
		}
		for(int i = 1; i<=n; i++) {
			int coin =  Integer.parseInt(br.readLine());
			for(int j = 0; j<=k; j++) {
				dp[i][j] = dp[i-1][j];
				if(j>=coin) {
					dp[i][j]=Math.min(dp[i][j],dp[i][j-coin]+1);
				}
			}
		}
		
		if(dp[n][k]>k) dp[n][k] = -1;
		
		
		
		bw.write(String.valueOf(dp[n][k]));
			
		bw.flush();
		bw.close();
		br.close();		
		
	}
}