import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int size = Integer.parseInt(br.readLine());

        int [] src = new int[size];
        int [] counting = new int[10001];
        int [] answer = new int[size];

        for(int i = 0 ; i < size; i++){
            src[i] = Integer.parseInt(br.readLine());
            counting[src[i]]++;
        }

        for(int i = 1; i<= 10000; i++){

                counting[i] += counting[i-1];

        }

        for(int i = 0; i< size; i++){
            int a = src[i];
            int index = counting[a] -1 ;
            answer[index] = src[i];
            counting[a]--;
        }

        for (int i : answer) {
            bw.write(String.valueOf(i) + '\n');
        }

        bw.flush();
        bw.close();
        br.close();
    }
}