
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 동전 개수
		int k = Integer.parseInt(st.nextToken()); // 목표 금액

		int[] coins = new int[n];
		for (int i = 0; i < n; i++) {
			coins[i] = Integer.parseInt(br.readLine());
		}

		int[][] dp = new int[n + 1][k + 1];
		dp[0][0] = 1; // 0원을 만드는 방법은 1가지 (아무 동전도 안 쓰는 것)

		for (int i = 1; i <= n; i++) {
			int coin = coins[i - 1];
			for (int j = 0; j <= k; j++) {
				// 이전 동전까지로 j원을 만드는 경우의 수
				dp[i][j] = dp[i - 1][j];

				// 현재 동전을 써서 j원을 만드는 경우
				if (j - coin >= 0) {
					dp[i][j] += dp[i][j - coin];
				}
			}
		}

		// j가 k로 나눈 나머지가 0인 경우만 최종 출력 (여기선 딱 k원을 만드는 경우)
		bw.write(dp[n][k] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
