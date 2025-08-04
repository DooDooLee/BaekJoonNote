import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList<Integer>> graph;
	static int n;
	static int[] value;
	static int min = Integer.MAX_VALUE;
	
	static ArrayList<Integer> comb;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n =  Integer.parseInt(br.readLine());
		value = new int[n+1];
		graph = new ArrayList<>();
		for(int i =0; i<=n; i++) {
			graph.add(new ArrayList<>());
		}
		
		StringTokenizer st = new StringTokenizer (br.readLine());
		
		for(int i = 1; i <=n; i++) {
			value[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i =1; i <=n; i++) {
			StringTokenizer st2 = new StringTokenizer (br.readLine());
			int j = Integer.parseInt(st2.nextToken());
			for(int k =0; k<j; k++) {
				int x = Integer.parseInt(st2.nextToken());
				graph.get(i).add(x);
				
			}
		}
		
		
		
		for(int i = 1; i <=n/2; i++) {
			comb = new ArrayList<>();
			combi(1,0,i);
			
		}
		
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		
		
		
		
	}

	
	public static void combi(int start,int d, int limit ) {
		if(d==limit) {
			check();
			 return;
		}
		for(int i =start; i<=n; i++) {
			comb.add(i);
			combi(i+1,d+1,limit);
			comb.remove(comb.size() - 1);
		}
	}
	
	public static void check() {
		int size = comb.size();
		int[] visited = new int[n+1];
		for(int x : comb) {
			visited[x] = 1;
		}
		Queue <Integer> q= new LinkedList<>();
		int sum = 0;
		int count = 0;
		
		q.add(comb.get(0));
		
		while(!q.isEmpty()) {
			int x= q.poll();
			visited[x] =0;
			sum += value[x];
			count ++;
			for(int nx : graph.get(x)) {
				if(visited[nx]==1) {
					q.add(nx);
					visited[nx] =0;
				}
			}
		}
		
		if (count!=size) return;
		
		
		
		
		
		q = new LinkedList<>();
		visited = new int[n+1];
		for(int x : comb) {
			visited[x] = 1;
		}
		int sum2 = 0;
		count = 0;
		int start = 0;
		for(int i=1;i<=n; i++) {
			if(visited[i]!=1) {
				start =i;
				break;
			}
		}
		if (start == 0) return; 
		q.add(start);
		while(!q.isEmpty()) {
			int x= q.poll();
			visited[x] =1;
			sum2 += value[x];
			count ++;
			for(int nx : graph.get(x)) {
				if(visited[nx]==0) {
					q.add(nx);
					visited[nx] =1;
				}
			}
		}
		if (count!=n-size) return;
		
		
		min= Math.min(min,Math.abs(sum-sum2));
		
		
		
		
	}
	
}
