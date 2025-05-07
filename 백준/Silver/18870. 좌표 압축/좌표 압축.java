
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Long[] arr = new Long[n];  // Integer에서 Long으로 변경
        Long[] arr2 = new Long[n]; // Integer에서 Long으로 변경
        ArrayList<Long> al = new ArrayList<>(); // Integer에서 Long으로 변경
        ArrayList<Long> al2 = new ArrayList<>(); // Integer에서 Long으로 변경
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Long, Integer> map = new HashMap<>(); // Integer에서 Long으로 변경

        for (int i = 0; i < n; i++) {
            Long t = Long.parseLong(st.nextToken()); // Long으로 변환
            arr[i] = t;
            arr2[i] = t;
        }

        Arrays.sort(arr, (a, b) -> Long.compare(b, a)); // int 비교 대신 Long.compare 사용

        al.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (!arr[i - 1].equals(arr[i])) { // Long의 equals 사용
                al.add(arr[i]);
            }
        }

        for (int i = 0; i < al.size(); i++) {
            map.put(al.get(i), al.size() - 1 - i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int ans = map.get(arr2[i]);  // 정답 출력
            sb.append(String.valueOf(ans)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
