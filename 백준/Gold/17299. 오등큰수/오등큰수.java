import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        int[] arr2 = new int[10000000+1];

        for(int i =0; i<n; i++){
           arr[i] = Integer.parseInt(st.nextToken());
           arr2[arr[i]]++;
        }



        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<n; i++){
            while(!stack.isEmpty() ){
                if(arr2[arr[i]]>arr2[arr[stack.peek()]]){
                arr[stack.pop()] = arr[i];}else break;
            }
            stack.push(i);
        }


        while(!stack.isEmpty()){
            arr[stack.pop()] = -1;
        }


        StringBuilder sb = new StringBuilder();

        for(int i : arr){
            sb.append(i).append(" ");
        }

        sb.deleteCharAt(sb.length()-1);


        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();




    }
}

