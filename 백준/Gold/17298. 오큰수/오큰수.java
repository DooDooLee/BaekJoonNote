import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int []arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stack = new Stack<>();

        for(int i =0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i =0; i<n; i++){
            while(!stack.isEmpty()){
                if(arr[stack.peek()]<arr[i]){
                   arr[stack.pop()]=arr[i];
                }else break;
            }
            stack.push(i);
        }

        while(!stack.isEmpty()){
            arr[stack.pop()]= -1;
        }

        for(int i=0; i<n; i++){
            sb.append(arr[i]).append(" ");
        }

        sb.deleteCharAt(sb.length() - 1);

        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }
}

