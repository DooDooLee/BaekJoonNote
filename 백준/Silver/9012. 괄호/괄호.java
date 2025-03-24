import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            boolean isValid = true;
            Stack st = new Stack();
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    st.push(s.charAt(i));
                } else if (s.charAt(i) == ')') {
                    if (st.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    st.pop();

                }


            }
            if (st.isEmpty() && isValid) {
                System.out.println("YES");
            } else System.out.println("NO");

        }

        br.close();
    }

}

