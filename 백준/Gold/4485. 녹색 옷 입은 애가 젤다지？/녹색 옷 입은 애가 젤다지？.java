import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int [ ][ ] map;
	static int [][] visited;
	static int [][] dist;
	static int dx[] = {0,0,1,-1};
	static int dy[] = {1,-1,0,0};
	static class Node implements Comparable<Node>{
		int x;
		int y;
		int w;
		Node(int x, int y, int w){
			this.x = x;
			this.y = y;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node other) {
			return this.w - other.w;
		}
		
		
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int count = 0;
		while(true) {
			count ++;
			n = Integer.parseInt(br.readLine());
			if(n==0) break;
			visited= new int[n][n];
			dist = new int[n][n];
			
			map = new int[n][n];
			for(int i =0; i<n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dist[i][j] = Integer.MAX_VALUE;
				}
			}
			
			Queue <Node>pq = new PriorityQueue<>();
			
			int x = 0;
			int y = 0;
			int w = map[0][0];
			dist[0][0] =w;
			pq.offer(new Node(x,y,w));
			
			
			while(!pq.isEmpty()) {
				Node  a = pq.poll();
				if(visited[a.x][a.y]==1) continue;
				visited[a.x][a.y] =1;
				for(int i =0; i<4; i++) {
					int nx = a.x + dx[i];
					int ny = a.y + dy[i];
					if(nx>=0 && nx<n && ny>=0 && ny<n) {
						int nw  = a.w + map[nx][ny];
						if(dist[nx][ny]>nw) {
							dist[nx][ny] = nw;
							pq.offer(new Node(nx,ny,nw));
						}
						
					}
				}
				
			}
			System.out.println("Problem "+count+":"+" "+dist[n-1][n-1]);
		}
		

	}
}
