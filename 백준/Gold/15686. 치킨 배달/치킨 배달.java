
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int min;
	static ArrayList <int []> h,c;
	static int [][] d;
	static int [] visited;
	static int[] temp;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		h = new ArrayList<>();
		c = new ArrayList<>();
		min = Integer.MAX_VALUE;
		
		for(int i =0; i<n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			for(int j =0; j<n; j++) {
				int what = Integer.parseInt(st2.nextToken());
				if( what == 1) {
					h.add(new int[] {i,j});
				}else if( what ==2) {
					c.add(new int[] {i,j});
				}
			}
		}
		d= new int[h.size()][c.size()];

		
		
		for(int i =0; i<h.size(); i++) {
			for(int j =0; j<c.size(); j++) {
				d[i][j] = Math.abs(h.get(i)[0]-c.get(j)[0])+ Math.abs(h.get(i)[1]-c.get(j)[1]);
			}
		}
		
		visited = new int [c.size()];		
		temp = new int [m];	
		
		for(int i =0;i<c.size(); i++) {
			back(i,1);
		
		}
		System.out.println(min);
		
	}
	static void back(int a,int depth) {
		visited[a] =1;
		if(depth == m) {
			int sum =0;
			int t =0;
			for(int i =0; i<c.size(); i++) {
				if(visited[i]==1) {
					temp[t] = i;
					t++;
				}
			}
			
			for(int i =0; i<h.size(); i++) {
				int tempMin = 999999;
				
				for(int j:temp) {
					tempMin = Math.min(tempMin, d[i][j]);
				}
				sum += tempMin;
			}
			min = Math.min(min,sum);
			visited[a] = 0; // 백트래킹 후 복원
	        return; // 조합 완성 후 더 이상 진행 X
		}
		
		for(int i=a+1; i<c.size(); i++) {
			 if (visited[i] == 0) {
	                back(i, depth + 1);
	            }
		}
		
		
		visited[a]=0;
		
	}
	
}

    
