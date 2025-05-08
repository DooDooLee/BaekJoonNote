import java.io.*;
import java.util.*;

public class Main {

	
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
      int n= Integer.parseInt(st.nextToken());
      int m = Integer.parseInt(st.nextToken());
      int k = Integer.parseInt(st.nextToken());
      int x = Integer.parseInt(st.nextToken());
      int [] d = new int[n+1];
      
      Arrays.fill(d,Integer.MAX_VALUE);
      
      ArrayList<ArrayList<Integer>> al = new ArrayList<>();
      Queue <int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
      
      for(int i=0; i<=n+1; i++) {
    	  al.add(new ArrayList<Integer>());
      }
      
      for(int i=0; i<m; i++) {
    	  StringTokenizer st2 = new StringTokenizer(br.readLine());
    	  int s =  Integer.parseInt(st2.nextToken());
    	  int a = Integer.parseInt(st2.nextToken());
    	  al.get(s).add(a);
      }
      d[x] =0;
      pq.add(new int[] {x,0});
      
      while(!pq.isEmpty()) {
    	  int [] c = pq.poll();
    	  int ci = c[0];
    	  int cw = c[1];
    	  
    	  if(cw>d[ci]) {
    		  continue;
    	  }
    	  
    	  for(int ni:al.get(ci)) {
    		  int nw = cw + 1;
    		  if(nw<d[ni]) {
    			  d[ni] = nw;
    			  pq.add(new int[] {ni,nw});
    		  }
    	  }
    	  
      }
      int count =0;
      for(int i =1; i<=n; i++) {
    	  if(d[i]==k) {
    		  count++;
    		  System.out.println(i);
    	  }
      }
      
      if(count==0) {
    	  System.out.println(-1);
      }
 
      
      
      
    
    
    }  
}    
    
