
import java.util.*;
import java.io.*;

public class Main {
	static int n;
	static int [][]arr;
	static boolean[][] visit;
	public static void main(String[] args)throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	n = Integer.parseInt(br.readLine());
	arr = new int[n][n];
	visit = new boolean [n][n];
	Integer [] answer = new Integer [n*n];
	int e =0;
	for(int i =0; i<n; i++) {
		String s = br.readLine();
		for(int j=0; j<n; j++) {
			answer[e] = 0;
			arr[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
			visit[i][j] =false;
			e++;
		}
	}
	int temp =0;
	int count =0;
	int x =0;
	for(int i =0; i<n; i++) {
		for(int j=0; j<n; j++) {
			temp =dfs(0,i,j);
			if(temp>0) {
				count++;
				answer[x] = temp;
				x++;
			}
		}
	}
	
	Arrays.sort(answer);
	
	System.out.println(count);
	for(int i =0; i<n*n; i++) {
		
			if(answer[i]>0) {
				System.out.println(answer[i]);
		
			
		}
	}
	
	
	br.close();
	}
	
	public static int dfs(int count, int i, int j) {
		if(i>=n|| j>=n ) {
			return count;
		}
		if(arr[i][j]==0 || visit[i][j]==true ) {
			return count;
		}else {
			visit[i][j] = true;
			count++;
			if(i>0) {
				if(j>0) {
					count = dfs(count,i,j+1);
					count = dfs(count,i+1,j);
					count = dfs(count, i-1,j);
					count = dfs(count, i,j-1);
				}else {
					count = dfs(count,i,j+1);
					count = dfs(count,i+1,j);
					count = dfs(count, i-1,j);
				}
			}else {
				if(j>0) {
					count = dfs(count,i,j+1);
					count = dfs(count,i+1,j);
					count = dfs(count, i,j-1);
				}else {
					count = dfs(count,i,j+1);
					count = dfs(count,i+1,j);
				}
			}
			
			return count;
		}
		
	}
	
	
	
}
