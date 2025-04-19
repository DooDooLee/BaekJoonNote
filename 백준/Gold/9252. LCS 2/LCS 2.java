
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String a  = br.readLine();
		String b  = br.readLine();
			
		int [][] dp = new int[a.length()+1][b.length()+1];
	
		
		
	
		
		for(int i = 1; i<=a.length(); i++) {
			for(int j=1; j<=b.length(); j++) {
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				}
			}
		}
		
		
		int i = a.length();
		int j = b.length();
		StringBuilder sb = new StringBuilder();
		
		while(i>0&&j>0) {
			if(a.charAt(i-1)==b.charAt(j-1)) {
				sb.append(a.charAt(i-1));
				j--;
				i--;
			}else {
				if(dp[i][j-1]>dp[i-1][j]) {
					j--;
				}else {
					i--;
				}
			}
		}
		
		 System.out.println(dp[a.length()][b.length()]);
	     System.out.println(sb.reverse().toString());

	
		br.close();		
		
	}
}