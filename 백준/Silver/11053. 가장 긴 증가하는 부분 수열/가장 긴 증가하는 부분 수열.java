
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
	    int [] v = new int[n+1];
	    int [] dp = new int[n+1];
	    
	    
	    
	    
	    StringTokenizer st  = new StringTokenizer(br.readLine());
	    for(int i = 1 ; i<=n; i++) {
	    	
	    	v[i] = Integer.parseInt(st.nextToken());
	    	
	    }
	    int max = dp[0];
	   
	    for(int i = 1; i<=n; i++) {
	    	for(int j = i-1; j>=0; j--) {
	    		if(v[i]>v[j] && dp[i]<dp[j]) { 
	    			dp[i] = dp[j];
	    		}
	    	}
	    	dp[i]++;
	    	if(max<dp[i]) {
	    		max = dp[i];
	    	}
	    }
	    
	   
	    
	    System.out.println(max);
	    
			
	
		br.close();		
		
	}
}