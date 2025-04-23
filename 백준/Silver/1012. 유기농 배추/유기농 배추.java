
import java.util.*;
import java.io.*;


public class Main {
	static int[][] arr;
	static  int[][] visit;
	static int m,n;
	static boolean isC;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int  t= Integer.parseInt(br.readLine());
		while(t-->0) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			m =Integer.parseInt(st.nextToken());
			n =Integer.parseInt(st.nextToken());
			int k =Integer.parseInt(st.nextToken());
			arr = new int[n][m];
			visit = new int[n][m];
			
			for(int i =0; i<k; i++) {
				StringTokenizer st1 = new StringTokenizer(br.readLine());
				int x =Integer.parseInt(st1.nextToken());
				int y =Integer.parseInt(st1.nextToken());
				arr[y][x] = 1;
			}
			int count = 0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					back(j,i);
					if(isC) {
						count++;
						isC = false;
					}
				}
			}
			
			System.out.println(count);
			
		
		
		
		

		}
	
		br.close();
	}
	
	public static void back(int x, int y) {
		if(x >=m||y>=n) {
			return;
		}else if(visit[y][x]==1 || arr[y][x]==0) {
			return;
		}else {
			visit[y][x] =1;
			if(y>0) {
				if(x>0) {
					back(x+1,y);
					back(x,y+1);
					back(x-1,y);
					back(x,y-1);
					
				}else {
					back(x+1,y);
					back(x,y+1);
					back(x,y-1);
				}
			}else {
				if(x>0) {
					back(x+1,y);
					back(x,y+1);
					back(x-1,y);
				}else {
					back(x+1,y);
					back(x,y+1);
				}
			}
			isC = true;
		}
	}
}
	
	

