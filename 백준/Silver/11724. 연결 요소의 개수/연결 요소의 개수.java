
import java.util.*;
import java.io.*;

public class Main {
	static List<Integer>[] arr;
	static boolean[] visited;
	static  int n, m;
	static int count =0;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new ArrayList[n+1];
		visited = new boolean[n+1];
		
		for (int i = 1; i <= n; i++) {
		    arr[i] = new ArrayList<>();
		    visited[i] = false;
		}
		
		for(int i =0; i<m; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			int j = Integer.parseInt(st1.nextToken());
			int k = Integer.parseInt(st1.nextToken());
			arr[j].add(k);
			arr[k].add(j);
		}
		
		for(int i =1; i<=n; i++) {
			if(!visited[i]) {
				count++;
				dfs(i);
			}
		}
		
		System.out.println(count);
		br.close();

	}
	
	public static void dfs(int x) {
		if(visited[x]) {
			return;
		}
		visited[x] = true;
		for(int i : arr[x]) {		
			dfs(i);
		}
	}
	
	
	
	
	
}
	
	

