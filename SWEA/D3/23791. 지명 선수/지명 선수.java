
import java.util.*;
import java.io.*;


public class Solution {
	public static void main(String[] args)throws IOException {
		//System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T;
		T=Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int n = Integer.parseInt(br.readLine());
			Character [] arr = new Character[n+1];
			
			int ap = 0;
			int bp = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			for(int i =1; i<=n; i++) {
				arr[i] = 'N'; 
			}
			
			while(ap<n&&bp<n) {
				while(ap<n) {
					int ai =Integer.parseInt(st.nextToken());
					if(arr[ai]=='N') {
						arr[ai] = 'A';
						ap++;
						break;
					}else {
						ap++;
					}
					
				}
				while(bp<n) {
					int bi =Integer.parseInt(st2.nextToken());
					if(arr[bi]=='N') {
						arr[bi] = 'B';
						bp++;
						break;
					}else {
						bp++;
					}
					
				}
				
			}
			
			
			
			
			
			
			for(int i =1; i<=n; i++) {
				System.out.print(arr[i]);}

			
				System.out.print("\n");
		}

		
	}
		
		
		
	
}
	
	

