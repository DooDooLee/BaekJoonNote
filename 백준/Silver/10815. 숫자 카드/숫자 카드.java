import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int[] arr2;

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int m  = Integer.parseInt(br.readLine());
        arr2 = new int[m];
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for(int i = 0; i < m; i++) { // 수정된 부분
            arr2[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++) {
            int a = search(arr2[i]);
            sb.append(a).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static int search(int k) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == k) {
                return 1;
            } else if(arr[mid] < k) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return 0;
    }
}
