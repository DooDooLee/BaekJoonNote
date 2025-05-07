
import java.io.*;
import java.util.*;

public class Main {
	static int n,c;
	static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int [n];
        
        for(int i =0; i<n; i++) {
        	arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        
        int left = 1;
        int right = arr[n-1] - arr[0];
        int ans = 0;
        while(left<=right) {
        	int mid = (right+left) /2 ;
        	if(isPos(mid)) {
        		ans = mid;
        		left = mid+1;
        	}else {
        		right = mid-1;
        	}
        
        	
        }
       System.out.println(ans);
        
        
    }
    
    static boolean isPos(int dis) {
    	int count = 1;
    	int last = arr[0];
    	for(int i =1; i<arr.length; i++) {
    		if(arr[i]-last>=dis) {
    			count++;
    			last = arr[i];
    		}
    	
    	}
    	return count>=c;
    	
    	
    	
    }
}
