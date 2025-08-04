import java.io.*;
import java.util.*;

public class Main {
	static int [] p;
	static boolean isFind =false;
	static int n,m;
	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		p = new int[n];
		for(int i = 0 ; i<n; i++) {
			p[i] = i;
		}
		
		for(int i =1; i<=m; i++) {
			StringTokenizer st2  =new StringTokenizer(br.readLine());
			int x =Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			if(find(x)==find(y)) {
				System.out.println(i);
				isFind = true;
				break;
			}
			union(x,y);
		}
		if(!isFind) {
			System.out.println(0);
		}
	}
	public static void union(int x, int y ) {
		int rootX = find(x);
		int rootY = find(y);
		
		p[rootY] = rootX;
		
	}
	public static int find(int x) {
		int rootX = p[x];
		if(rootX != x) {
			p[x] = find(rootX);
		}
		return p[x];
	}
}
