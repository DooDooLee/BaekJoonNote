import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Node>> graph;
	static int n;
	static int[] d;
	static int[] prev;
	
	
	
	public static class Node implements Comparable<Node> {
		int to;
		int w;
		public Node(int to,int w) {
			this.to= to;
			this.w = w;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	
	
	public static void main(String[] args)throws IOException{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m =  Integer.parseInt(st.nextToken());
		
		prev =  new int[n+1];
		d = new int[n+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		graph = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			graph.add(new ArrayList<Node>());
		}
		
		while(m-->0) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st2.nextToken());
			int to = Integer.parseInt(st2.nextToken());
			int w = Integer.parseInt(st2.nextToken());
			graph.get(start).add(new Node(to,w));
			graph.get(to).add(new Node(start,w)); //간선 추가 양방향 신 경 쓰 자!
		}
		
		Queue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(1,0));
		d[1]=0;
		
		while(!pq.isEmpty()) {
			Node a =pq.poll();
			int to = a.to;
			int w = a.w;
			for(Node nt : graph.get(to)) {
				int nextTo = nt.to;
				int nw = nt.w+w;
				if(d[nextTo]>nw) {
					prev[nextTo] = to;
					d[nextTo] = nw;
					pq.offer(new Node(nextTo,nw));
				}
			}
			
		}
		
		System.out.println(n-1);
		for(int i=2; i<=n; i++) {
			System.out.println(i+" "+prev[i]);
		}
	
	
	}
	
}