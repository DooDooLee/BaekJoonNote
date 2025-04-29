
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int [][] dp = new int [a.length()+1][b.length()+1];
		
		for(int j=1; j<b.length(); j++) {
			if(a.charAt(0)==b.charAt(j-1)) {
				dp[1][j] = 1;
			}
		}
		
		
		for(int i=2; i<=a.length(); i++) {
			for(int j = 1; j<=b.length(); j++) {
				if(j==1) {
					if(a.charAt(i-1)==b.charAt(j-1)) {
						dp[i][j]=1; 
					}
				}else {
					if(a.charAt(i-1)==b.charAt(j-1)) {
						if(a.charAt(i-2)==b.charAt(j-2)){
							dp[i][j]= dp[i-1][j-1]+1;
						}else {
							dp[i][j]=1;
						}
					}
					
				}
			}
		}
		
		int max = 0;
		for(int i=1; i<=a.length(); i++) {
			for(int j = 1; j<=b.length(); j++) {
				max = Math.max(max,dp[i][j]);
			}
		}
		System.out.println(max);
		
		br.close();
	}
}
