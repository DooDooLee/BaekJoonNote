
import java.util.*;
import java.io.*;

public class Main {
	static Character[][] arr;
	static boolean[] visit = new boolean[26];
	static int max = 0;
	static int r;
	static int c;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		
		arr = new Character[r][c];
		
		for(int i =0; i<r; i++) {
			String a = br.readLine();
			for(int j=0; j<c; j++) {
				arr[i][j] = a.charAt(j);
			}
		}
		
		for(int i =0; i<26; i++) {
			visit[i] = false;
		}
		
		int count = 0;
		back(count,0,0);
		
		
		System.out.println(max);
		
		
		
		
		
	}
	
	
	
	public static void back(int count, int i, int j) {
		if(i>=r || j>=c) {
			max = Math.max(count,max);
			return;
		}
		if(!visit[arr[i][j]-'A']) {
			visit[arr[i][j]-'A'] =true;
			count++;
			if(i>0) {
				if(j>0) {
					
					back(count,i-1,j);
					back(count,i,j-1);
					back(count,i+1,j);
					back(count,i,j+1);
					
				}else if(j==0) {
					back(count,i+1,j);
					back(count,i,j+1);
					back(count,i-1,j);
					
				}
			}else if(i==0) {
				if(j>0) {
					back(count,i,j-1);
					back(count,i+1,j);
					back(count,i,j+1);
				}else if(j==0) {
					back(count,i+1,j);
					back(count,i,j+1);
				}
				
			}
			max = Math.max(count,max);
			visit[arr[i][j]-'A'] =false;
			
		}
		
		
		
	}
	
	
}
