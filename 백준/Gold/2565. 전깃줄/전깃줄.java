
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
	    int [] a = new int[501];
	    int [] v = new int[n+1];
	    int [] dp = new int [n+1];
	    for (int i =0; i<=500; i++) {
	    	a[i] = 501;
	    }
	    
	    for (int i =1; i<=n; i++) {
	    	StringTokenizer st = new StringTokenizer(br.readLine());
	    	a[Integer.parseInt(st.nextToken())]=Integer.parseInt(st.nextToken());
	    }
	   int j = 1;
	   for(int i = 1; i<=500; i++) {
		  if(a[i]<=500) {
			  v[j] = a[i];
			  j++;
		  }
		  
	   }
	    
	   
	   for(int i =1 ; i<=n; i++) {
		   
		   for(int k = i-1; k>0; k--) {
			   if(v[i]>v[k]&&dp[k]>dp[i]) {
				   dp[i] = dp[k];
			   }
		   }
		   dp[i]++;
	   }
	   
	   int max = 0;
	   for(int i =1; i<=n;i++) {
		   if(max<dp[i]) {
			   max = dp[i];
		   }
	   }
	   
	   System.out.println(n-max);
	    
	   
			
	
		br.close();		
		
	}
}