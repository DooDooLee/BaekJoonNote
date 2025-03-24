import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> st = new Stack<>();
        
        int T = Integer.parseInt(br.readLine());
        int current = 1;  // 1부터 시작
        boolean isValid = true;

        for (int i = 0; i < T; i++) {
            int target = Integer.parseInt(br.readLine());

            // target 값이 current보다 크다면, current부터 target까지 push
            while (current <= target) {
                st.push(current++);
                sb.append("+\n");
            }

            // 스택의 top이 target이면 pop
            if (!st.isEmpty() && st.peek() == target) {
                st.pop();
                sb.append("-\n");
            } else {
                isValid = false;
                break;
            }
        }

        // 수열을 만들 수 없으면 "NO" 출력
        if (isValid) {
            System.out.print(sb);
        } else {
            System.out.println("NO");
        }

        br.close();
    }
}
