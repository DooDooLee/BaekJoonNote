import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        LinkedList<Integer> stack = new LinkedList<>();

        while (n-- > 0) {
            st = new StringTokenizer(br.readLine(), " ");

            switch (st.nextToken()) {
                case "push":
                    stack.addFirst(Integer.parseInt(st.nextToken()));
                    break;

                case "pop":
                    Integer a = stack.pollFirst();
                    if (a == null) {
                        a = -1;
                    }
                    sb.append(a).append("\n");
                    break;

                case "size":
                    sb.append(stack.size()).append("\n");
                    break;

                case "empty":
                    if (stack.isEmpty())
                        sb.append(1).append("\n");
                    else
                        sb.append(0).append("\n");
                    break;

                case "top":
                    Integer b = stack.peekFirst();
                    if (b == null) {
                        b = -1;
                    }
                    sb.append(b).append("\n");
                    break;
            }

        }
        br.close();

        // 수정된 부분: Scanner 사용을 위해 주석 처리
        // Scanner sc = new Scanner(System.in);

        // bw에 내용 쓰고 출력
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
}
