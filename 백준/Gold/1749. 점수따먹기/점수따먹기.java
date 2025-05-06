import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringTokenizer st = new StringTokenizer(br.readLine());

	int n = Integer.parseInt(st.nextToken());
	int m =  Integer.parseInt(st.nextToken());
	
	int [][] arr = new int [n][m];
	int [][] p =new int[n+1][m+1];
	
	for(int i=0;i<n;i++) {
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for(int j =0; j<m; j++) {
			arr[i][j] = Integer.parseInt(st2.nextToken());
		}
	}
	
	
	for(int i=1;i<=n;i++) {
		for(int j =1; j<=m; j++) {
			p[i][j] = p[i-1][j] + p[i][j-1] - p[i-1][j-1] +arr[i-1][j-1 ];
		}
	}
	int max = -Integer.MAX_VALUE;

	for(int i=1;i<=n;i++) {
		for(int j =1; j<=m; j++) {
			for(int k = i; k>=1; k--) {
				for(int q = j; q>=1; q--) {
					int sum =p[i][j] - p[i][q-1] - p[k-1][j] + p[k-1][q-1];
					max = Math.max(sum,max);
				}
			}
		}
	}
	System.out.println(max);
	
	
	
	
	}
}
