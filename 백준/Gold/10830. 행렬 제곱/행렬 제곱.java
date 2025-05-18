
import java.io.*;
import java.util.*;

public class Main {
	static long [][] arr;
	static int n;
	static long b;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		b = Long.parseLong(st.nextToken());
		
		arr = new long[n][n];
		
		for(int i =0; i<n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			for(int j =0; j<n; j++) {
				arr[i][j] = Long.parseLong(st2.nextToken())%1000;
			}
		}
		
		arr = pow(arr,b);
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<n;i++) {
			for(int j=0; j<n; j++) {
				sb.append(String.valueOf(arr[i][j])+" ");
			}
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
		
	}
	static long[][] pow(long[][]a, long x){
		if(x==1L) {
			return a;
		}
		long [][] half = pow(a,x/2);
		long [][] r = m(half,half);
		if(x%2==1L) {
			return m(r,a);
		}else{
			return r;
		}
	}
	
	
	static long[][] m(long[][] a,long[][] x){
		long[][] result = new long[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				long sum = 0;
				for(int k=0;k<n;k++) {
					
					sum += a[i][k] * x[k][j];
				}
				result[i][j] = sum%1000;
			}
			
		}
		return result;
	}
	
}

    
