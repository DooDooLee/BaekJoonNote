
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n  = Integer.parseInt(br.readLine());
        StringTokenizer st =  new StringTokenizer(br.readLine());
        
        int[][] dp = new int[n+1][n+1]; 
        // dp[i][j]: i번 카드팩까지 사용해서 j장을 만들 때 최대 금액
        
        for (int i = 1; i <= n; i++) {
            int coin = Integer.parseInt(st.nextToken()); // i장이 들어있는 카드팩의 가격

            for (int j = 0; j <= n; j++) {
                // 이전 카드팩까지 고려한 값 그대로 가져오기
                dp[i][j] = dp[i-1][j];

                // i장짜리 카드팩을 사용해서 j장을 만들 수 있다면
                if (j >= i) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - i] + coin);
                }
            }
        }

        bw.write(String.valueOf(dp[n][n])); // 정확히 n장을 만드는 최대 금액
        bw.flush();
        bw.close();
        br.close();
    }
}
