
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n  = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [][] dp = new int [n+1][k+1];
		dp[0][0] =1;
		
		for(int i = 1; i<=n; i++) {
			int coin = Integer.parseInt(br.readLine());
			for(int j =0; j<=k; j++) {
				dp[i][j] = dp[i-1][j]; // 이전 동전까지 j 를 만드는 경우의 수 , 즉 이번동전 안쓴다고 했을때 경우의 수로 일단 초기화
				
				if(j>=coin) {
					dp[i][j] += dp[i][j-coin]; //이번 동전 쓴다고 하면, 이번동전까지 고려한 상태에서  j-coin 을 만드는 경우의 수를 더해줌
					//즉 i 번째 동전까지 고려했을때 j 를 만들수 있는 경우의 수 = 이번 동전 안 쓰는 경우 + 이번 동전 쓰는 경우
				}
			}
		}
		
		bw.write(String.valueOf(dp[n][k]));
			
		bw.flush();
		bw.close();
		br.close();		
		
	}
}