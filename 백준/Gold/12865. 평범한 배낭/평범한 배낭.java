
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		long [][] dp = new long[n+1][k+1];
		
		for(int i =1; i<=n; i++) {
			StringTokenizer st2  = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st2.nextToken());
			int v = Integer.parseInt(st2.nextToken());
			
			for(int j = 0; j<=k; j++) {
				if(j<w) {
					dp[i][j] = dp[i-1][j];
				}else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w]+v);
				}
				
			}
			
			
		}
		
		
		bw.write(String.valueOf(dp[n][k]));
					
			
		bw.flush();
		bw.close();
		br.close();		
		
	}
}