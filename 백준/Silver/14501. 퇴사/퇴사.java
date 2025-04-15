import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 총 날짜 수
        int[] T = new int[N + 1]; // 각 날의 상담 기간
        int[] P = new int[N + 1]; // 각 날의 상담 수익
        int[] dp = new int[N + 1]; // 각 날까지의 최대 수익

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            // 지금까지의 최댓값 유지 (i일에 상담을 안 했을 수도 있음)
            dp[i] = Math.max(dp[i], dp[i - 1]);

            int end = i + T[i] - 1;
            if (end <= N) {
                dp[end] = Math.max(dp[end], dp[i - 1] + P[i]);
            }
        }

        // 최댓값은 N일 혹은 그 이전까지의 max(dp[i]) 중 가장 큰 값
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
