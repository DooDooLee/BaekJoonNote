import java.io.*;
import java.util.*;

public class Main {
	static int n,m,s,d;
	static StringBuilder sb;
	static ArrayList<ArrayList<int []>> graph ,rGraph;
	static int [] dist, dist2 ,dist3;
	static int min;
	
	
	
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			
			
			if(n==0 && m==0) break;
			
		
			graph = new ArrayList<>();
			rGraph = new ArrayList<>();
			for(int i = 0; i<n; i++) {
				graph.add(new ArrayList<>());
				rGraph.add(new ArrayList<>());
			}
			
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			s =Integer.parseInt(st2.nextToken());
			d = Integer.parseInt(st2.nextToken());
			
			for(int i=0; i<m; i++) {
				StringTokenizer st3 = new StringTokenizer(br.readLine());
				int u = Integer.parseInt(st3.nextToken());
				int v = Integer.parseInt(st3.nextToken());
				int p = Integer.parseInt(st3.nextToken());
				graph.get(u).add(new int[] {v,p}); //{도착지, 비용}
				rGraph.get(v).add(new int[] {u,p});
			}
			
			dist = new int[n];
			dist2 = new int[n];
			dist3 = new int[n];
			for(int i = 0 ; i<n; i++) {
				dist[i] = Integer.MAX_VALUE;
				dist2[i] = Integer.MAX_VALUE;
				dist3[i] = Integer.MAX_VALUE;
			}
			
			min = Integer.MAX_VALUE;
			
			PriorityQueue<int []> pq = new PriorityQueue<>(
				(a,b)->{
					return a[1] - b[1];	
				}	
			);
			
			pq.offer(new int[] {s,0});
			
			while(!pq.isEmpty()) {
				int [] cur = pq.poll();
				int x = cur[0];
				int w = cur[1];
				
				if(dist[x]<w ) {
					continue;
				}
				
		
				dist[x] = w;
				
				for(int[] next : graph.get(x)) {
					int nX = next[0];
					int nW = next[1] + w;
					
					if(dist[nX]>nW) {
						dist[nX] = nW;
						pq.offer(new int[] {nX, nW});
					}
				}
				
				
			}
			
			
			
			pq.clear();
			pq.offer(new int[] {d,0});
			
			while(!pq.isEmpty()) {
				int [] cur = pq.poll();
				int x = cur[0];
				int w = cur[1];
				
				if(dist2[x]<w ) {
					continue;
				}
				
		
				dist2[x] = w;
				
				for(int[] next : rGraph.get(x)) {
					int nX = next[0];
					int nW = next[1] + w;
					
					if(dist2[nX]>nW) {
						dist2[nX] = nW;
						pq.offer(new int[] {nX, nW});
					}
				}
				
				
			}
			
			pq.clear();
			pq.offer(new int[] {d,0});
			
			while(!pq.isEmpty()) {
				int [] cur = pq.poll();
				int x = cur[0];
				int w = cur[1];
				
				if(dist3[x]<w ) {
					continue;
				}
				
				dist3[x] = w;
				
				for(int [] next : rGraph.get(x)) {
					int nx = next[0];
					int nw = next[1]+w;
					if(dist[nx]+dist2[x]+next[1]==dist[d])  continue;
					
					if(dist3[nx]>nw) {
						dist3[nx] = nw;
						pq.offer(new int[] {nx,nw});
					}
					
				}
				
			}
			
			if(dist3[s]==Integer.MAX_VALUE) {
				sb.append(-1).append("\n");
			}else {
				sb.append(dist3[s]).append("\n");
			}
			
			
			
			
		}
		
		System.out.println(sb.toString().trim());
		
		                                                                                                                                                                                                                   
	}
	
	
	
	
	
		
	
	
}
