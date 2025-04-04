import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]); 
        int N = Integer.parseInt(input[1]);  

        boolean[] isPrime = new boolean[N + 1]; 
        for (int i = 2; i <= N; i++) isPrime[i] = true; 

     
        for (int i = 2; i * i <= N; i++) { 
            if (isPrime[i]) { 
                for (int j = i * i; j <= N; j += i) { 
                    isPrime[j] = false;
                }
            }
        }

      
        for (int i = M; i <= N; i++) {
            if (isPrime[i]) {
                bw.write(i + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
