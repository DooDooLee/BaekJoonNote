import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String[] numbers = new String[n];
            HashSet<String> set = new HashSet<>();

            for (int i = 0; i < n; i++) {
                numbers[i] = br.readLine();
                set.add(numbers[i]);
            }

            boolean isConsistent = true;

            for (String number : numbers) {
                StringBuilder prefix = new StringBuilder();
                // 접두어 확인: 마지막 글자는 제외 (전체 문자열은 본인과 같으니까!)
                for (int i = 0; i < number.length() - 1; i++) {
                    prefix.append(number.charAt(i));
                    if (set.contains(prefix.toString())) {
                        isConsistent = false;
                        break;
                    }
                }
                if (!isConsistent) break;
            }

            System.out.println(isConsistent ? "YES" : "NO");
        }
    }
}
