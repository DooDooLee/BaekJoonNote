
import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int n, m ;
    static int[] blue = new int[2];
    static int[] red = new int[2];
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean isV = false;

    public static void main(String[] args)throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
        	String a = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = a.charAt(j);
                if (map[i][j] == 'B') {
                    blue[0] = i;
                    blue[1] = j;
                }
                if (map[i][j] == 'R') {
                    red[0] = i;
                    red[1] = j;
                }
            }
        }

        back(blue[0], blue[1], red[0], red[1], 0);

        System.out.println(isV ? 1 : 0);
    }

    public static void back(int bx, int by, int rx, int ry, int depth) {
        if (isV) return; 
        if (depth == 10) return;

        int[] r = new int[3]; 
        int[] b = new int[3]; 

        for (int i = 0; i < 4; i++) {
            if (i == 0) { // 상
                if (rx < bx) { 
                    r = move(rx, ry, i, 'R');
                    b = move(bx, by, i, 'B');
                } else {
                    b = move(bx, by, i, 'B');
                    r = move(rx, ry, i, 'R');
                }
            } else if (i == 1) { // 하
                if (rx < bx) {
                    b = move(bx, by, i, 'B');
                    r = move(rx, ry, i, 'R');
                } else {
                    r = move(rx, ry, i, 'R');
                    b = move(bx, by, i, 'B');
                }
            } else if (i == 2) { // 좌
                if (ry > by) {
                    b = move(bx, by, i, 'B');
                    r = move(rx, ry, i, 'R');
                } else {
                    r = move(rx, ry, i, 'R');
                    b = move(bx, by, i, 'B');
                }
            } else if (i == 3) { // 우
                if (ry > by) {
                    r = move(rx, ry, i, 'R');
                    b = move(bx, by, i, 'B');
                } else {
                    b = move(bx, by, i, 'B');
                    r = move(rx, ry, i, 'R');
                }
            }
            

            if (r[2] == 1 && b[2] == 0) {
                isV = true;
                return;
            } else if (b[2] == 1) {
            	 if (r[2] == 0) map[r[0]][r[1]] = '.';
                map[bx][by] = 'B';
                map[rx][ry] = 'R';
               
            } else if (b[2] == 0 && r[2] == 0) {
                back(b[0], b[1], r[0], r[1], depth + 1);
                map[r[0]][r[1]] = '.';
                map[b[0]][b[1]] = '.';
                map[bx][by] = 'B';
                map[rx][ry] = 'R';
              
            }
        }
    }

    public static int[] move(int x, int y, int w, char a) {
        int nx = x + dx[w];
        int ny = y + dy[w];

        while (nx >= 0 && nx <= n - 1 && ny >= 0 && ny <= m - 1) {
            if (map[nx][ny] == '.') {
                nx += dx[w];
                ny += dy[w];
            } else if (map[nx][ny] == 'O') {
                map[x][y] = '.';
                return new int[]{nx, ny, 1};
            } else {
                map[x][y] = '.';
                map[nx - dx[w]][ny - dy[w]] = a;
                return new int[]{nx - dx[w], ny - dy[w], 0};
            }
        }
        return new int[]{x, y, 0};
    }
}