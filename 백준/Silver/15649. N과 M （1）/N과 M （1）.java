import java.util.*;
import java.io.*;



public class Main {
    static int n, m;
    static int[] arr, temp;
    static boolean[] visit;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // ✅ 전역으로 이동

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        temp = new int[m];
        visit = new boolean[n];

        for(int i = 0; i < n; i++) arr[i] = i + 1;

        back(0);
        bw.flush(); 
        br.close();
        bw.close();  
    }

    public static void back(int depth)throws IOException {
        if(depth == m) {
            for(int i = 0; i < m; i++) {
                bw.write(temp[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visit[i]) {
                temp[depth] = arr[i];
                visit[i] = true;
                back(depth + 1);
                visit[i] = false;
            }
        }
    }  
}
