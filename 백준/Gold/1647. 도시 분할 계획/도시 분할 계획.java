import java.io.*;
import java.util.*;

public class Main {
	static class Way{
		int x;
		int y;
		int weight;
		public Way(int x,int y,int weight){
			this.x=x;
			this.y=y;
			this.weight=weight;
		}
	}
	static int []parent;
	static ArrayList<Way> al;
	public static void main(String[] args)throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	al =  new ArrayList<>();
	int sum =0;
	int max =0;
	
	for(int i =0; i<m; i++) {
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st2.nextToken());
		int y = Integer.parseInt(st2.nextToken());
		int w = Integer.parseInt(st2.nextToken());
		
		al.add(new Way(x,y,w));
	}
	parent = new int [n+1];
	for(int i=1; i<=n; i++) {
		parent [i] = i;
	}
	Collections.sort(al,(a,b)->a.weight-b.weight);
	
	for(Way temp : al) {
		int x = temp.x;
		int y = temp.y;
		int w = temp.weight;
		if(find(x) != find(y)) {
			max= Math.max(w,max);
			union(x,y);
			sum +=w;
		}
	
		
		
		
	}
	sum = sum-max;
	System.out.println(sum);
	
	
	
	
	
	
	
	
	}
	static void union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		parent[rootX] = rootY;
	} 
	static int find(int x) {
		if(parent[x]!=x) {
			parent[x]=find(parent[x]);
		}
		return parent[x];
		
	}
	
		
}

		
