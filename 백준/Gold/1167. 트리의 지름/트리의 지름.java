import java.io.*;
import java.util.*;

public class Main  {
	static ArrayList <ArrayList<int[]>> graph;
	static int n;
	static int max;
	static int [] v;
	static int temp;
	public static void main(String [] args )throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
			n = Integer.parseInt(br.readLine());
			v = new int[n+1];
			graph = new ArrayList<>();
			
			for(int i =0; i<=n; i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0;i<n;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int start = Integer.parseInt(st.nextToken());
				while(true) {
					int  to =Integer.parseInt(st.nextToken());
					if (to==-1) break;
					int  w = Integer.parseInt(st.nextToken());
					graph.get(start).add(new int[] {to,w});
				}
			}
			max = Integer.MIN_VALUE;
			temp=0;
			dfs(1,0);
			int x = temp;
			
			max = Integer.MIN_VALUE;
			v = new int[n+1];
			dfs(temp,0);
			int y  = temp;
		
			System.out.println(max);
	}
	
	public static void dfs(int x , int sum) {
		v[x] =1;
		if(sum>max) {
			temp = x;
			max = sum;
		}
		for(int[] arr : graph.get(x)) {
			
			int to = arr[0];
			if(v[to]==0) {
				int w = sum + arr[1];
				dfs(to,w);
			}
		}
		v[x]=0;
	}
	
	
	
	
}
