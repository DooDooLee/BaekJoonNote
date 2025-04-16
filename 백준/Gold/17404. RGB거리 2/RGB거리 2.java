
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		final int inf = 9999999;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int n = Integer.parseInt(br.readLine());
		int [][]rgb = new int [n][3];
		int [][] dp = new int [n][3];
		for(int i = 0; i<n; i++ ) {
			StringTokenizer st =  new StringTokenizer(br.readLine());
			rgb[i][0] = Integer.parseInt(st.nextToken());
			rgb[i][1] = Integer.parseInt(st.nextToken());
			rgb[i][2] = Integer.parseInt(st.nextToken());
		}
		
		int [] start = new int[3];
		start[0]=rgb[0][0];
		start[1]=rgb[0][1];
		start[2]=rgb[0][2];
		
		int [] result = new int[3];
		
		int x=2;
		while(x >=0) {
			if(x==2) {
				dp[0][2] = rgb[0][2];
				dp[0][1] = inf;
				dp[0][0] = inf;
			}else if(x==1) {
				dp[0][1] = rgb[0][1];
				dp[0][0] =inf;
				dp[0][2] = inf;
			}else {
				dp[0][0] = rgb[0][0];
				dp[0][1] =inf;
				dp[0][2] =inf;
			}
			for(int i = 1; i<n; i++) {
					dp[i][0] = Math.min(dp[i-1][1],dp[i-1][2])+rgb[i][0];
					dp[i][1] = Math.min(dp[i-1][0],dp[i-1][2])+rgb[i][1];
					dp[i][2] = Math.min(dp[i-1][0],dp[i-1][1])+rgb[i][2];	
			}
			if(x==2) {
				result[x] = Math.min(dp[n-1][0],dp[n-1][1]);
			}else if(x==1) {
				result[x] = Math.min(dp[n-1][0],dp[n-1][2]);
			}else {
				result[x] = Math.min(dp[n-1][2],dp[n-1][1]);
			}
			x--;
		}
		
		
		result[0] = Math.min(result[0],result[1]);
		result[0] = Math.min(result[0],result[2]);
		
		System.out.println(result[0]);
		
			
		bw.flush();
		bw.close();
		br.close();		
		
	}
}