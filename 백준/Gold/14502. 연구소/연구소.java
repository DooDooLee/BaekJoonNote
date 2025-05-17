
import java.io.*;
import java.util.*;

public class Main {
	static int[][]map,visited;
	static ArrayList <int[]> zero;
	static ArrayList <int[]> virus;
	static int max;
	static int n,m;
	static int count;
	static int twoCount;
	static int oneCount;
	static int [] dx = {-1,0,0,1};
	static int [] dy = {0,-1,1,0};
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map=new int[n][m];
		visited=new int[n][m];
		zero = new ArrayList<>();
		virus = new ArrayList<>();
		for(int i =0; i<n; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());

			for(int j=0; j<m; j++) {
				map[i][j] =Integer.parseInt(st2.nextToken());
				
				if(map[i][j]==0) {
					zero.add(new int[] {i,j});
					
				}else if(map[i][j]==2) {
					virus.add(new int[] {i,j});
					
				}
				
			}
		}
		max = 0;
		for(int i =0; i<zero.size()-2; i++) {
			for(int j=i+1; j<zero.size()-1; j++) {
				for(int k = j+1; k<zero.size(); k++) {
					
					visited=new int[n][m];
					
					count = 0;
					twoCount = 0;
					
					int zx = zero.get(i)[0];
					int zy = zero.get(i)[1];
					map[zx][zy] =1;
					int zx2 = zero.get(j)[0];
					int zy2 = zero.get(j)[1];
					map[zx2][zy2] =1;
					int zx3 = zero.get(k)[0];
					int zy3 = zero.get(k)[1];
					map[zx3][zy3] =1;
					
					for(int [] temp : virus) {
						int tx = temp[0];
						int ty = temp[1];
						if(visited[tx][ty]==0) {
							dfs(tx,ty);
						}
						
					}
					
					count = zero.size() - 3 -twoCount+virus.size();
					
					max = Math.max(count,max);
					
					map[zx][zy] =0;
					map[zx2][zy2] =0;
					map[zx3][zy3] =0;
				}
			}
		}
		
		System.out.println(max);
		
		
		
		
		
	}
	static void dfs(int x,int y){
		
		visited[x][y] =1;
		twoCount++;
		for(int i =0; i<4; i++) {
			int nx = x+dx[i];
			int ny = y+dy[i];
			if(nx>=0 &&nx<n && ny>=0 &&ny<m) {
				if(visited[nx][ny]!=1 && map[nx][ny]!=1) {
					dfs(nx,ny);
				}
			}
		}
		
	}
	
}

    
