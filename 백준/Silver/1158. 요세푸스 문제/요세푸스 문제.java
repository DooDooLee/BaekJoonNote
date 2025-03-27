import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i<=N; i++){
            queue.offer(i);
        }

        sb.append("<");
        while(!queue.isEmpty()){
            for(int i = 1; i<K; i++){
                queue.offer(queue.poll());
            }
            sb.append(queue.poll());
            sb.append(", ");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.deleteCharAt(sb.length()-1);
        sb.append(">");

        bw.write(sb.toString());


        br.close();
        bw.flush();
        bw.close();
    }
}

