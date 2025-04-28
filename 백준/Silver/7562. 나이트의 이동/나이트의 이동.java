
import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] visit;
	static int l;
	static int sx,sy,gx,gy;
	static int[] dx, dy;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		dx = new int[] {-2,-2,-1,-1,1,1,2,2};
		dy = new int[] {-1,1,-2,2,-2,2,-1,1};
		while(t-->0) {
			l = Integer.parseInt(br.readLine());
			
			visit = new int[l][l];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			sx = Integer.parseInt(st.nextToken());
			sy = Integer.parseInt(st.nextToken());
		
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			gx = Integer.parseInt(st2.nextToken());
			gy = Integer.parseInt(st2.nextToken());
			if(sx==gx && sy==gy) {
				System.out.println(0);
			}else {
				bfs();
				System.out.println(visit[gy][gx]-1);
			}
		}
		br.close();
	}
	
	
	static void bfs() {
		Queue<int []> q  = new LinkedList<>();
		q.add(new int[] {sx,sy});
		visit[sy][sx]++;
		
		while(!q.isEmpty()) {
			int [] temp = q.poll();
			int cx = temp[0];
			int cy = temp[1];
			int v = visit[cy][cx];
			
			
			for(int i =0; i<8; i++) {
				int x = cx+dx[i];
				int y = cy+dy[i];
				if(x>=0&&y>=0&&x<l&&y<l) {
					if(visit[y][x]==0) {
						 visit[y][x] = v+1;
						 if(y==gy&&x==gx) return;
						 q.add(new int[] {x,y});
					}
				}
			}
		}
		
		
	}
}
