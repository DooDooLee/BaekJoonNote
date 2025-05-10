import java.io.*;
import java.util.*;
public class Main {
    static int n;
    static int result = 0;
    static boolean[] col;         // 열 체크
    static boolean[] diag1;       // ↘ 대각선 체크 (row + col)
    static boolean[] diag2;       // ↙ 대각선 체크 (row - col + n - 1)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        col = new boolean[n];
        diag1 = new boolean[2 * n - 1];
        diag2 = new boolean[2 * n - 1];

        backtrack(0);
        System.out.println(result);
    }

    static void backtrack(int row) {
        if (row == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (col[i] || diag1[row + i] || diag2[row - i + n - 1]) continue;

            col[i] = true;
            diag1[row + i] = true;
            diag2[row - i + n - 1] = true;

            backtrack(row + 1);

            col[i] = false;
            diag1[row + i] = false;
            diag2[row - i + n - 1] = false;
        }
    }
}
