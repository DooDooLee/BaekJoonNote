import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // N이 1인 경우, 바로 출력하고 종료
        if (n == 1) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        // BFS를 위한 큐, 경로 추적을 위한 부모 배열, 방문 체크 배열
        Queue<Integer> queue = new LinkedList<>();
        int[] parent = new int[n + 1]; // parent[i] = i로 오기 전의 숫자
        boolean[] visited = new boolean[n + 1];

        // 시작점 초기화
        queue.add(n);
        visited[n] = true;

        // BFS 시작
        while (!queue.isEmpty()) {
            int current = queue.poll();

            // 목표인 1에 도달하면 루프 종료
            if (current == 1) {
                break;
            }

            // 다음 탐색할 노드들을 큐에 추가
            // 1. 3으로 나누는 경우
            if (current % 3 == 0) {
                int next = current / 3;
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = current;
                    queue.add(next);
                }
            }

            // 2. 2로 나누는 경우
            if (current % 2 == 0) {
                int next = current / 2;
                if (!visited[next]) {
                    visited[next] = true;
                    parent[next] = current;
                    queue.add(next);
                }
            }

            // 3. 1을 빼는 경우
            int next = current - 1;
            if (next > 0 && !visited[next]) {
                visited[next] = true;
                parent[next] = current;
                queue.add(next);
            }
        }

        // 경로 역추적 (Stack 사용)
        Stack<Integer> path = new Stack<>();
        int curr = 1;
        while (curr != 0) { // 시작점 N에 도달할 때까지
            path.push(curr);
            curr = parent[curr];
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(path.size() - 1).append("\n"); // 연산 횟수
        while (!path.isEmpty()) {
            sb.append(path.pop()).append(" "); // 경로
        }
        System.out.println(sb);
    }
}