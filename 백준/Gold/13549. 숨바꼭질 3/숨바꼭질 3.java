import java.io.*;
import java.util.*;

public class Main {

	
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [] d = new int [200000];
        int [] dx =new int[] {-1,1};
        
        Arrays.fill(d,Integer.MAX_VALUE);
        
        Queue<int []> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[] {n,0});
        while(!pq.isEmpty()) {
        	int [] c = pq.poll();
        	int ci = c[0];
        	int cw = c[1];
        	if(ci==k) {
        		if(d[k]>cw) {
        			d[k] =cw;
        			}
        	}
        	
        	
        	for(int i =0; i<=2; i++) {
        		int nw = cw;
        		int ni;
        		if(i==2) {
        			ni = ci*2;
        		}else {
        			ni = ci+dx[i];
        			nw = cw+1;
        		}
        		
        		if(ni>=0 &&ni<200000) {
        			if(d[ni]>nw) {
        				d[ni] =nw;
            			pq.add(new int[] {ni,nw});
            		}
        		}
        		
        	}
        }
        
        
        System.out.println(d[k]);
    }

}    
