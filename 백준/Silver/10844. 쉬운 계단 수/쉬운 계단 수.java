import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		final long m = 1_000_000_000;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());

		
		long [][] dp = new long [101][10];
		
		
		dp[1][0] = 0;
		for(int i = 1; i<=9; i++) {
			dp[1][i]=1;
			if(i>=2 &&i<9) {
				dp[2][i]=2;
			}else if(i==9) {
				dp[2][i] = 1;
			}
		}
		dp[2][0] = 1;
		dp[2][1] = 1;
		
		
		for(int i=3; i<=100; i++) {
			for(int j=0; j<=9; j++) {
				if(j==0) {
					dp[i][j]=dp[i-1][1]%m;
				}else if(j==9) {
					dp[i][j] = dp[i-1][8]%m;
				}else {
					dp[i][j] = dp[i-1][j-1]%m+dp[i-1][j+1]%m;
				}
			}
		}
		long sum =0;
		for(int i = 0; i<=9; i++) {
			sum = (sum + dp[n][i])%m;
		}
		
		System.out.println(sum);
		
		
		
		
		
		
		bw.flush();
		bw.close();
		
		br.close();		
		
	}
}