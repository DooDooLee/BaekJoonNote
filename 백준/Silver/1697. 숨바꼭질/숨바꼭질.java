
import java.io.*;
import java.util.*;

public class Main {
	
	 
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] visit = new int[100_001];
		
		if(n!=k) {
			Queue<Integer> q = new LinkedList<>();
			q.add(n);
			visit[n]++;
			while(!q.isEmpty()) {
				int c = q.poll();
				if(c==k) {
					break;
				}
				int v = visit[c];
				int x;
				for(int i=0; i<3; i++) {
					if(i==0) {
						x= c-1;
					}else if(i==1) {
						x= c+1;
					}else {
						x= c*2;
					}
				
				
				
					if(x>=0&&x<=100_000) {
						if(visit[x]==0) {
							visit[x] = v+1;
							if(x==k) break;
							q.add(x);
						}
					}
						
				}
			
		}
		System.out.println(visit[k]-1);
	}else {
		System.out.println(0);
	}
		
		
		
		
	
	}
		
}
