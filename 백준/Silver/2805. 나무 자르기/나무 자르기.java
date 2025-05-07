
import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int [] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr =  new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i =0; i<n; i++) {
        	arr[i] = Integer.parseInt(st2.nextToken());
        }
        
        Arrays.sort(arr);
        
        int left = 0;
        int right = arr[n-1]-1;
        int ans =0;
        while(left<=right) {
        	int mid = (left+right)/2;
        	if(isPos(mid)) {
        		ans =mid;
        		left = mid+1;
        	}else {
        		right=mid-1;
        	}
        }
        
        System.out.println(ans);
    }
    static boolean isPos(int h) {
    	long sum =0;
    	for(int i =0; i<n; i++) {
    		int t = arr[i]-h;
    		if(t>0) {
    			sum+=t;
    		}
    	}
    	return sum>=m;
    }
}
