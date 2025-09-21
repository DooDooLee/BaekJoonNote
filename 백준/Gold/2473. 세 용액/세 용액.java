import java.util.*;
import java.io.*;

public class Main {
   
    
    
    public static void main(String[] args) throws IOException {
    	//System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [] arr = new int [n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
       
        long min = Long.MAX_VALUE;
        int x=0, y=0, z =0;
        
        for(int i =0;i<n-2; i++) {
        	int l = i+1;
        	int r = n-1;
        	
        	while(l<r) {
        		long sum = arr[l] + arr[r];
        		
        		if(min > Math.abs(sum+arr[i])) {
        			min = Math.abs(sum+arr[i]);
        			x = arr[i];
        			y = arr[l];
        			z = arr[r];
        			
        		}
        		
        		if(sum>-arr[i]) {
        			r--;
        		}else if(sum<-arr[i]) {
        			l++;
        		}else if(sum==-arr[i]) {
        			break;
        		}
        		
        	}
        	
        }
        
        
        System.out.println(x+" "+y+" "+z);
        
        
        
    } 
}