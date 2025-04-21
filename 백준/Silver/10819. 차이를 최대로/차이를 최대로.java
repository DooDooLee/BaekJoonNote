
import java.util.*;
import java.io.*;

public class Main {
	static int result =0;
    public static void main(String[] args)throws IOException{
    	
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int n = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	
    	int [] arr = new int[n];
    	int [] temp = new int[n];
    	boolean [] visited = new boolean[n];
    	for(int i =0; i<n; i++) {
    		arr[i] = Integer.parseInt(st.nextToken());
    	}
    	
    	
    	
    	back(0,n,visited,temp,arr);
    	System.out.println(result);
    	
    	br.close();
    	
    	
    }
    
    public static void back(int depth,int n,boolean[] visited,int[] temp,int[] arr) {
    	if(depth ==n) {
			int sum = 0;
			for(int i=0; i<n-1; i++) {
				sum += Math.abs(temp[i]-temp[i+1]);
			}
			result = Math.max(result,sum);
			return;
		}
    	
    	
    	for(int i = 0; i<n; i++) {
    		
    		if(!visited[i]) {
    			temp[depth] = arr[i];
    			visited[i] = true;
    			back(depth+1,n,visited,temp,arr);
    			visited[i] = false;
    		}
    	}
    }
  
    
}
