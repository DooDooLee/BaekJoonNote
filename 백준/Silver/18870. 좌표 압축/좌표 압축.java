
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Long[] arr = new Long[n];
        Long[] arr2 = new Long[n];
        ArrayList<Long> al = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<Long, Integer> map = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            Long t = Long.parseLong(st.nextToken());
            arr[i] = t;
            arr2[i] = t;
        }

        Arrays.sort(arr, (a, b) ->Long.compare(b,a)); 

        al.add(arr[0]);
        for (int i = 1; i < n; i++) {
            if (!arr[i - 1].equals(arr[i])) {
                al.add(arr[i]);
            }
        }

        for (int i = 0; i < al.size(); i++) {
            map.put(al.get(i), al.size() - 1 - i);
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int ans = map.get(arr2[i]);
            sb.append(String.valueOf(ans)).append(" ");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
