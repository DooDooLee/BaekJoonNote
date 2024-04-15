import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        int[] a = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++){
            a[i] = Integer.parseInt(br.readLine());
            sum += a[i];
        }

        Arrays.sort(a);

        for(int i=0; i<8; i++){
            for(int j =i+1; j<9; j++){
                if(sum-a[i]-a[j] == 100){
                    for(int b:a){
                        if(b!=a[i]&b!=a[j]){
                            sb.append(b).append("\n");
                        }
                    }
                    i=8;
                    break;
                }
            }
        }
        bw.write(sb.toString());
        br.close();
        bw.flush();
        bw.close();
    }
}