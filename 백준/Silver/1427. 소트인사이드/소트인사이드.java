import java.io.*;
import java.util.*;



public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long i = Integer.parseInt(br.readLine());
        ArrayList<Long> result = new ArrayList<>();
        int index = 0;

        while(i != 0){
            long a;
            a = i % 10;
           result.add(a);
            i /= 10;
        }

        Collections.sort(result, Collections.reverseOrder());

        for(Long x : result){
            bw.write(String.valueOf(x));
        }

        bw.flush();
        bw.close();
        br.close();




    }
}