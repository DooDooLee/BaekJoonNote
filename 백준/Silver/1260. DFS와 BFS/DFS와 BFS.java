
import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList <Integer>> al;
	static int [] visit;
	static StringBuilder sb;
	static StringBuilder sb2;
	public static void main(String[] args)throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	StringTokenizer st = new StringTokenizer(br.readLine());
	sb = new StringBuilder();
	sb2 = new StringBuilder();
	
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	int v = Integer.parseInt(st.nextToken());
	
	visit = new int[n+1];
	al = new ArrayList<>();
	
	for(int i =0; i<=n; i++) {
		al.add(i,new ArrayList<>());
		}
	
	
	 for(int i=1; i<=m; i ++) {
		 StringTokenizer st2 = new StringTokenizer(br.readLine());
		 int idx =  Integer.parseInt(st2.nextToken());
		 int node =  Integer.parseInt(st2.nextToken());
		 al.get(idx).add(node);
		 al.get(node).add(idx);
	 }
	
	for(int i =1; i<=n; i++) {
		Collections.sort(al.get(i));
	}
	
	dfs(v);
	visit = new int[n+1];
	bfs(v);
	bw.write(sb+"\n"+sb2);
	
	
	 
	 
	 
	 
	
	br.close();
	bw.flush();
	bw.close();
	}
	
	
	static void dfs(int x) {
		ArrayList<Integer> nodes = al.get(x);
		
		if(visit[x]==0) {
			sb.append(x+" ");
			visit[x]=1;
	
			for(int i =0; i<nodes.size(); i++) {
				dfs(nodes.get(i));
			
			}
		}
		
		return;
		
		
	}
	
	static void bfs(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(x);
		
		while(!q.isEmpty()) {
			int a = q.poll();
			if(visit[a]==0) {
				sb2.append(a+" ");
				visit[a]=1;
				ArrayList<Integer> nodes = al.get(a);
				
				for(int i =0; i<nodes.size(); i++) {
					q.offer(nodes.get(i));
				}
			}
		}
		
	}
	
	

	
}
