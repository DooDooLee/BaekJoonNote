
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a = br.readLine();
		String b = br.readLine();
	   
		int n = a.length();
		int n2 = b.length();
		int [][] dp = new int[n+1][n2+1];
		
		for(int i = 1; i<=n; i++) {
			for(int j=1; j<=n2; j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j]= dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		
		
		
		System.out.println(dp[n][n2]);
		
			
	
		br.close();		
		
	}
}