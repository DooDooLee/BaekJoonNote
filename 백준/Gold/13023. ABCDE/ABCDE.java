import java.util.*;
import java.io.*;

public class Main {
    static boolean isLine = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[n];
        ArrayList<Integer>[] adjacent = new ArrayList[n]; // 인접 리스트를 배열로 선언

        // 각 인접 리스트를 초기화
        for (int i = 0; i < n; i++) {
            adjacent[i] = new ArrayList<>(); // 각 인덱스에 ArrayList 초기화
        }

        // 간선 정보를 입력받아 인접 리스트에 추가
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adjacent[a].add(b); // a에서 b로 연결
            adjacent[b].add(a); // b에서 a로 연결 (무향 그래프)
        }

        // DFS를 통해 경로 탐색
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            dfs(i, adjacent, visited, 1);
            if (isLine) {
                break;
            }
        }

        // 결과 출력
        bw.write(isLine ? "1" : "0");
        bw.flush();
        bw.close();
        br.close();
    }

    // DFS 메서드
    static void dfs(int index, ArrayList<Integer>[] adjacent, boolean[] visited, int cnt) {
        if (cnt == 5) {
            isLine = true;
            return;
        }
        visited[index] = true; // 현재 노드 방문 처리
        for (int i : adjacent[index]) { // 연결된 노드 탐색
            if (!visited[i]) {
                dfs(i, adjacent, visited, cnt + 1);
            }
            if (isLine) {
                return; // 경로가 발견되면 반환
            }
        }
        visited[index] = false; // 백트래킹
    }
}
