
import java.io.*;
import java.util.*;

public class Main {
	static int [] p;
	static int [] visited;
	static ArrayList<ArrayList<Integer>> al;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		al = new ArrayList<>();
		visited = new int[n+1];
		p = new int[n+1];
		for(int i=0; i<=n; i++) {
			al.add(new ArrayList<Integer>());
			
		}
		for(int i =1; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int e= Integer.parseInt(st.nextToken());
			
			al.get(a).add(e);
			al.get(e).add(a);
		}
		dfs(1);
		for(int i=2; i<=n; i++) {
			System.out.println(p[i]);
		}
	
		
	}
	static void dfs(int x) {
		visited[x]=1;
		
		for(int a : al.get(x)) {
			if(visited[a]==0) {
				p[a] = x;
				dfs(a);
			}
		}
		
	}
}    
    
