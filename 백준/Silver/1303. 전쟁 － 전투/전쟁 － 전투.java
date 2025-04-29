
import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] visit ;
	static char[][] arr ;
	static int[] dx ;
	static int[] dy ;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		dx = new int[] {-1,0,0,1};
		dy = new int[] {0,1,-1,0};
		n=Integer.parseInt(st.nextToken());
		m=Integer.parseInt(st.nextToken());
		int countW=0;
		int countB=0;
		arr= new char[m][n];
		visit = new int[m][n];
		
		for(int i=0; i<m; i++) {
			String s= br.readLine();
			for(int j=0; j<n; j++) {
				arr[i][j] =s.charAt(j);
			}
		}
		

		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(visit[i][j]==0) {
					if(arr[i][j]=='W') {
						int count = bfs(j,i,'W');
						countW+=count*count;
					}else {
						int count = bfs(j,i,'B');
						countB+=count*count;
					}
				}
			}
		}
		
		System.out.println(countW+" "+countB);
		
		
		
		
		br.close();
		
	
	}
	
	
	static int bfs(int x, int y, char a) {
		int count =1;
		Queue<int []> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visit[y][x]=1;
		while(!q.isEmpty()) {
			int [] temp = q.poll();
			int cx = temp[0];
			int cy = temp[1];
			
			for(int i =0; i<4; i++) {
				int nx = cx+dx[i];
				int ny = cy+dy[i];
				
				if(nx>=0 && ny>=0 && nx<n && ny<m) {
					if(visit[ny][nx] ==0 && arr[ny][nx]==a) {
						visit[ny][nx]=1;
						q.add(new int[] {nx,ny});
						count++;
					}
				}
				
				
				
			}
		}
		
		return count;
	}
		
}
