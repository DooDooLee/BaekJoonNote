
import java.util.*;
import java.io.*;

public class Main {
    static int n, m;
    static int[][] arr;
    static int[][] visit;
    static int[] dx = {0, 0, -1, 1}; // 좌우상하
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visit = new int[n][m];

        for (int i = 0; i < n; i++) {
            String a = br.readLine();
            for (int j = 0; j < m; j++) { // 여긴 m
                arr[i][j] = a.charAt(j) - '0'; // 바로 문자 - '0' 하면 숫자됨
            }
        }

        bfs(0, 0); // 시작점 (0,0)

        System.out.println(visit[n-1][m-1]);
    }

    public static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        visit[x][y] = 1; // 시작지점은 depth 1

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int cx = temp[0];
            int cy = temp[1];

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (arr[nx][ny] == 1 && visit[nx][ny] == 0) {
                        visit[nx][ny] = visit[cx][cy] + 1; // 거리 1 추가
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}
