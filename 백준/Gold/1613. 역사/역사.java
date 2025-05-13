
import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [][] arr = new int [n+1][n+1];
		for(int i =0; i<n+1; i++) {
			Arrays.fill(arr[i], 9999);
		}
		
		for(int i =0; i<k; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st2.nextToken());
			int e = Integer.parseInt(st2.nextToken());
			arr[d][e] = 1;

		}
		int s = Integer.parseInt(br.readLine());
		
		
		for(int m=1; m<=n; m++) {
			for(int i =1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					int way = arr[i][m] + arr[m][j];
					if(way<arr[i][j]) {
						arr[i][j]=way;
					}
				}
			}
		}
		
		
		
		

		for(int i =0; i<s; i++) {
			StringTokenizer st3 = new StringTokenizer(br.readLine());
			int d = Integer.parseInt(st3.nextToken());
			int e = Integer.parseInt(st3.nextToken());
			
			if(arr[d][e]>=9999 && arr[e][d]>=9999) {
				System.out.println(0);
			}else if(arr[d][e] >= 9999) {
				System.out.println(1);
			}else {
				System.out.println(-1);
			}
		}
		
		
	}
	
}    
    
