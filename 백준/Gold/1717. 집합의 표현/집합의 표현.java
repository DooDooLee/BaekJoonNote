
import java.io.*;
import java.util.*;

public class Main {
	static int []set;
	
	public static void main(String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		set = new int [n+1];
		for(int i=1; i<=n;i++){
			set[i] = i;
		}
		for(int i =0; i<m; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int order = Integer.parseInt(st2.nextToken());
			int a  = Integer.parseInt(st2.nextToken());
			int b = Integer.parseInt(st2.nextToken());
			if(order==0) {
				union(a,b);
			}else if(order==1) {
				if(find(a)==find(b)) {
					System.out.println("YES");
				}else {
					System.out.println("NO");
				}
	}
		}
		
		
	}
	
	 static int find(int x) {
	        if (set[x] != x) {
	            set[x] = find(set[x]);
	        }
	        return set[x];
	    }
	
	static void union(int a,int b) {
		int rootA = find(a);
		int rootB = find(b);
		if(rootA != rootB) {
			set[rootB] = rootA;
		}
	}
	
}    
    
