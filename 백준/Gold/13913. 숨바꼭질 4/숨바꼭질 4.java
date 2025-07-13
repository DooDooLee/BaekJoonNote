import java.io.*;
import java.util.*;

public class Main {
	static int[][] p  = new int[100001][2];
	static int[] dx = new int[] {1,-1,2};
	static int[] v = new int[100001];
	static int n,k;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		bfs();
		br.close();
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		 v[n] = 1;             
	     p[n][1] = 0;    
	     
		while(!q.isEmpty()) {
			int x = q.poll();
			if(x==k) {
				System.out.println(p[x][1]);
				int [] result = new int[p[x][1]+1];
				result[0] = x;
				for(int i =1; i<result.length; i++) {
					x = p[x][0];
					result[i]= x;
				}
				for(int i =result.length-1; i>=0; i--) {
					System.out.print(result[i]+" ");
				}
				
				return;
			}
			
			
			for(int i =0; i<3; i++) {
				if(i==2) {
					int next = x*dx[i];
					if(next>=0 &&next<100001&&v[next]==0) {
						v[next]=1;
						p[next][0] = x;
						p[next][1] = p[x][1]+1;
						q.offer(next);
					} 
					
				}else {
					int next = x+dx[i];
					if(next>=0 &&next<100001&&v[next]==0) {
						v[next]=1;
						p[next][0] = x;
						p[next][1] = p[x][1]+1;
						q.offer(next);
					}
				} 
			}
			
			
		}
		
		
		
		
	}
	
	
	
	
	
	
	
	
}