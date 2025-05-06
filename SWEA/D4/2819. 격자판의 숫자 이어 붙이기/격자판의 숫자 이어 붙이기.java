
import java.io.*;
import java.util.*;

public class Solution {
	  static HashSet<String> set;
	
	static int [] dx = {-1,0,0,1};
	static int [] dy = {0,-1,1,0};
	static Integer [][] arr;
	public static void main(String[] args)throws IOException {
		
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int t = Integer.parseInt(br.readLine());
	
	for(int tc=1; tc<=t; tc++) {
		arr= new Integer [4][4];
		set = new HashSet<>();
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int j=0; j<4; j++) {
				arr[i][j]=Integer.parseInt(st.nextToken()); 
			}
		}

		
		for(int i=0; i<4; i++) {
			for(int j=0; j<4; j++) {
				dfs(i,j,"");
			}
		}
		
		System.out.println("#"+tc+" "+set.size());
		
		
	}
	
	
	
	
	
	}
	
	static void dfs(int x, int y, String temp) {
		temp += String.valueOf(arr[x][y]);
		boolean isValid = true;
		  if (temp.length() == 7) {
	            set.add(temp); // HashSet은 중복 자동 제거
	            return;
	        }
		if(temp.length()<7) {
			for(int i =0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				
				if(nx>=0 && ny >=0 && nx<4 && ny<4) {
					dfs(nx,ny,temp);
				}
			}
		}
	}
}
