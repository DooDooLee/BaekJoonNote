
import java.io.*;
import java.util.*;

public class Main {
	static int [ ] dp;
	static int [] arr;
	public static void main(String[] args)throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	dp = new int [n+1];
	arr = new int [n+1];
	for(int i =1; i<=n; i++) {
		arr[i] =  Integer.parseInt(br.readLine());
	}
	
	
	dp[0] = 0;
	if(n>=1){
	dp[1] = arr[1];
	if(n>=2) {
	dp[2] = arr[1]+arr[2];
	}
	}
	System.out.println(find(n));
	
	br.close();
	
	}
	
	static int find(int x) {
		
		if(dp[x]==0&&x>2) {
			dp[x] = Math.max(find(x-2),find(x-3)+arr[x-1])+arr[x];
		}
		
		return dp[x];
		
		
	}
}
