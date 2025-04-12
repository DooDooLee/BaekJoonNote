
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		final long m = 10007;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		long [][] dp = new long [1001][10];
		
		for(int i = 0; i<=9; i++) {
			dp[1][i] = 1;
		}
		
		for(int i =2; i<=1000; i++) {
			dp[i][0]=1;
			for(int j=1; j<=9; j++) {
				for(int k = j; k>=0; k--) {
					dp[i][j] = (dp[i][j] + dp[i-1][k])%m;
				}
				
			}
		}
		
		long sum = 0;
		
		for(int i = 0; i<=9; i++) {
			sum = (sum + dp[n][i]) % m ;
		}
		
		bw.write(String.valueOf(sum));
		
					
		
		bw.flush();
		bw.close();
		
		br.close();		
		
	}
}