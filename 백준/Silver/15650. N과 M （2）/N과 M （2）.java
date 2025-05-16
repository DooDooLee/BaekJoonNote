
import java.io.*;
import java.util.*;

public class Main {
	static int m;
	static int n;
	static int[] result;
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		result = new int[m];
		for(int i =1; i<=n; i++) {
			result[0] = i;
			dfs(i,0);
		}

	}
	static void dfs(int x, int depth) {
		if(depth == m-1) {
			for(int t : result) {
				System.out.print(t+" ");
			}
			System.out.println();
			return;
		}
		for(int i =x+1; i<=n; i++) {
			result[depth+1] = i;
			dfs(i,depth+1);
		}
	}
}

    
