
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	
	int[] []dp = new  int[n+1][n+1];
	StringTokenizer st = new StringTokenizer(br.readLine());
	int p = Integer.parseInt(st.nextToken());
	for(int j =1; j<=n; j++) {	
		dp[1][j] = dp[1][j-1]+p;
	}
	for(int i =2; i<=n; i++) {
		p = Integer.parseInt(st.nextToken());
		for(int j =1; j<=n; j++) {
			dp[i][j] = dp[i-1][j];
			if(j>=i) {
				dp[i][j] = Math.min(dp[i][j],dp[i][j-i]+p);
			}
		}
	}
	
	System.out.println(dp[n][n]);
	br.close();
	
	}
}
