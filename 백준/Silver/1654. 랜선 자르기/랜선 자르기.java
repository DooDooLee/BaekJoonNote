import java.io.*;
import java.util.*;

public class Main {
	static int n,k;
	static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        
        arr= new int[k];
        int max=0;
        for(int i=0; i<k; i++) {
        	arr[i]=Integer.parseInt(br.readLine());
        	max = Math.max(max,arr[i]);
        }
        
        long left = 1;
        long right = max;
        long ans =0;
        
        while(left<=right) {
        	long mid = (left+right)/2;
        	if(isPos(mid)) {
        		ans = mid;
        		left = mid+1;
        	}else {
        		right = mid-1;
        	}
        	
        }
        
        
        System.out.println(ans);
        
        
        
        
        
    }
    static boolean isPos(long dis) {
    	long count = 0;
    	for(int i =0;i<k;i++) {
    		count+= arr[i]/dis;
    	}
    	
    	return count >=n;
    }
}    
