import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        boolean isValid = true;
        int current = 1;
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for(int i =0; i<T; i++){
            int number = Integer.parseInt(br.readLine());
            while(current <= number){
                st.push(current);
                sb.append("+\n");
                current++;
            }
            if(st.pop() != number){
                System.out.println("NO");
                isValid = false;
                break;
            }
            sb.append("-\n");

        }

        if(isValid){
            System.out.println(sb.toString());
        }

        br.close();
    }
}

