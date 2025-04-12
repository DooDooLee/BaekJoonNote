import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		final long m = 10007;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		long [][] dp = new long [91][2];
		
		dp[1][0]=0;
		dp[1][1]=1;
		if(n>1) {
			dp[2][0]=1;
			dp[2][1]=0;
		}
		if(n>=3) {
			for(int i =3; i<=n; i++) {
				dp[i][0] = dp[i-1][1]+dp[i-1][0];
				dp[i][1] = dp[i-1][0];
			}
		}
		
		long sum = dp[n][0]+dp[n][1];
	
		bw.write(String.valueOf(sum));
					
		
		bw.flush();
		bw.close();
		
		br.close();		
		
	}
}