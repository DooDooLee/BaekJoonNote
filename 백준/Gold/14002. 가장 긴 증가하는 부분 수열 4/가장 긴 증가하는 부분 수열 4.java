
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int  n = Integer.parseInt(br.readLine());
		int [] v = new int[n+1];
		int [] dp = new int[n+1];
		String [] result = new String[n+1];
		for (int i = 0; i <= n; i++) {
		    result[i] = "";
		}
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i  = 1 ; i <= n; i++) {
			v[i] =  Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1; i<=n; i++) {
			int index = 0;
			for(int j= i-1; j>=1; j--) {
				if(v[i] > v[j] &&  dp[j]>dp[i]) {
					dp[i]=dp[j];
					result[i] =result[j];
				}
			}
			
			dp[i]++;
			
			result[i]+=String.valueOf(v[i]);
			result[i]+= " ";
		}
		
		
		
		int max =0;
		int maxIndex=0;
		
		for(int i =1; i<=n; i++) {
			if(max<dp[i]) {
				max = dp[i];
				maxIndex = i;
			}
		}
		
		
		System.out.println(max);
		System.out.println(result[maxIndex]);
			
	
		br.close();		
		
	}
}