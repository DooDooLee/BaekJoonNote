
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int arr [][] =new int [n][n];
		int p[][] = new int [n+1][n+1];
		for(int i=0; i<n;i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			for(int j =0; j<n; j++) {
				arr[i][j] = Integer.parseInt(st1.nextToken());		
			}
				
		}
		
		
		for(int i = 1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				p[i][j] = arr[i-1][j-1] +p[i][j-1]+p[i-1][j]-p[i-1][j-1];
			}
		}
		
		
		while(m-->0) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			int x1 = Integer.parseInt(st2.nextToken());		
			int y1 = Integer.parseInt(st2.nextToken());		
			int x2 = Integer.parseInt(st2.nextToken());		
			int y2 = Integer.parseInt(st2.nextToken());	
			
			int sum = p[x2][y2]-p[x1-1][y2]-p[x2][y1-1] + p[x1-1][y1-1];
			System.out.println(sum);
			
		}
		

		
		
		
		
		
		
		
		
	
			
		
		
		
		
	}
	

}
