
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	
	int[] []dp = new  int[n+1][101];
	int [] hp = new int[n];
	int [] joy = new int[n];
	StringTokenizer st = new StringTokenizer(br.readLine());
	for(int i =0; i<n; i++) {
	
		hp[i] = Integer.parseInt(st.nextToken());
		
	}
	StringTokenizer st1 = new StringTokenizer(br.readLine());
	for(int i =0; i<n; i++) {
	
		joy[i] = Integer.parseInt(st1.nextToken());
	}
	
	for(int i =1; i<=n; i++) {
		for(int j=1; j<=100; j++) {
			dp[i][j] = dp[i-1][j];
			if(j>hp[i-1]) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-hp[i-1]] + joy[i-1]);
			}
		}
	}
	
	System.out.println(dp[n][100]);
	br.close();
	
	}
}
