
import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args)throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	int [][]  arr = new int[n][3];
	int [][] dp = new int [n][3];
	
	
	
	for(int i =0; i<n; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int j =0; j<3; j++) {
			arr[i][j]=Integer.parseInt(st.nextToken());
		}
	}
	
	dp[0][0] = arr[0][0];
	dp[0][1] = arr[0][1];
	dp[0][2] = arr[0][2];
	
	
	for(int i =1; i<n; i++) {
		for(int j=0; j<3; j++) {
			if(j==0) {
				dp[i][j] = Math.max(dp[i-1][j+1],dp[i-1][j])+arr[i][j];
			}else if(j==1) {
				dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
				dp[i][j] = Math.max(dp[i][j] , dp[i-1][j+1]+arr[i][j]);
			}else {
				dp[i][j] = Math.max(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
			}
		}
	}
	
	int max = Math.max(dp[n-1][0],dp[n-1][1]);
	max = Math.max(max,dp[n-1][2]);
	
	dp = new int [n][3];
	dp[0][0] = arr[0][0];
	dp[0][1] = arr[0][1];
	dp[0][2] = arr[0][2];
	
	
	for(int i =1; i<n; i++) {
		for(int j=0; j<3; j++) {
			if(j==0) {
				dp[i][j] = Math.min(dp[i-1][j+1],dp[i-1][j])+arr[i][j];
			}else if(j==1) {
				dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j]) + arr[i][j];
				dp[i][j] = Math.min(dp[i][j] , dp[i-1][j+1]+arr[i][j]);
			}else {
				dp[i][j] = Math.min(dp[i-1][j-1],dp[i-1][j])+arr[i][j];
			}
		}
	}
	
	int min = Math.min(dp[n-1][0],dp[n-1][1]);
	min = Math.min(min,dp[n-1][2]);
	
	System.out.println(max+" "+min);
	
	
	
    br.close();
	

	}
}
