import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][n+1];

        // 무한대로 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }

        // 자기 자신은 0으로 초기화
        for (int i = 1; i <= n; i++) {
            arr[i][i] = 0;
        }

        // 전후 관계 입력
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = 1; // 단방향 그래프
        }

        // 플로이드-워셜
        for (int m = 1; m <= n; m++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (arr[i][m] != Integer.MAX_VALUE && arr[m][j] != Integer.MAX_VALUE) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][m] + arr[m][j]);
                    }
                }
            }
        }

        // 쿼리 처리
        int s = Integer.parseInt(br.readLine());
        for (int i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            if (arr[d][e] != Integer.MAX_VALUE) {
                System.out.println(-1); // d가 e보다 먼저 발생
            } else if (arr[e][d] != Integer.MAX_VALUE) {
                System.out.println(1); // e가 d보다 먼저 발생
            } else {
                System.out.println(0); // 알 수 없음
            }
        }
    }
}
