
import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][] answer = new int[1000001][2];
		int [] arr = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());


		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			answer[arr[i]][0] =1;
			
		}
		
		
		for(int i =0; i<n; i++) {
			for(int j = arr[i]+arr[i]; j<=1000000; j+=arr[i]) {
				if(answer[j][0]==1) {
					answer[j][1]--;
					answer[arr[i]][1]++;
				}
			}
		}
		
		
		StringBuilder sb = new StringBuilder();
		for(int i : arr) {
			sb.append(String.valueOf(answer[i][1])+" ");
		}
		System.out.println(sb.toString());
	}
	
	
		
}

		
