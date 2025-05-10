
import java.util.*;
import java.io.*;


public class Solution {
	static int count = 0;
	static int[][] arr  = new int [100][100];
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		for(int tc =1; tc<=10; tc++) {
			count =0;
			Integer.parseInt(br.readLine());
			
			for(int i=0;i<100;i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j =0; j<100;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			
			
			
			for(int i =0; i<100;i++) {
				find(0,i);
			}
			
			System.out.println("#"+tc+" "+count);
			
			
			
			
		}
	}
	
	static void find(int x ,int y) {
		int minN = 999;
		int minS = 999;
		for(int i = x; i<100; i++) {
			if (arr[i][y]==1) {
				minN = Math.min(minN,i);
			}
			else if (arr[i][y]==2) {
				minS = Math.min(minS,i);
			}
		}
		if(minN==999||minS==999) {
			return;
		}
		if(minN<minS) {
			count ++;
			find(minS+1,y);
		}else if(minN>minS) {
			find(minN,y);
		}
		
	}
	
	
	
}
	
	

