
import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Way> al;
	static int[] p;
	static class Way {
		int a;
		int b;
		int v;
		
		Way(int a, int b, int v){
			this.a=a;
			this.b=b;
			this.v=v;
		}
	}
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int v= Integer.parseInt(st.nextToken());
		int e = Integer.parseInt(st.nextToken());
		al = new ArrayList<>();
		p = new int[v+1];
		for(int i =1; i<=v; i++) {
			p[i]=i;
		}
		for(int i =0 ;i<e; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st2.nextToken());
			int y = Integer.parseInt(st2.nextToken());
			int w = Integer.parseInt(st2.nextToken());
			al.add(new Way(x,y,w));
		}
		
		Collections.sort(al,(a,b)->Integer.compare(a.v,b.v));
		int result =0;
		int count =0;
		for(Way w : al) {
			if(count==v-1) break;
			if(find(w.a)!=find(w.b)) {
				result += w.v;
				union(w.a , w.b);
				count++;
			}
			
		}
		
		System.out.println(result);
		
	}
	static void union(int x, int y) {
		int Rx = find(x);
		int Ry = find(y);
		
		p[Rx]  = p[Ry];
		
	}
	static int find(int x) {
		if(p[x]!=x) {
			p[x]= find(p[x]);
		}
		return p[x];
	}
	
}    
    
