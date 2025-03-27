import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        boolean insideTag = false; // 태그 내부 여부 체크

        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);

            if (ch == '<') { 
                // 스택에 남아있는 문자들 먼저 처리
                while (!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                insideTag = true; // 태그 내부 진입
                sb.append(ch); // '<' 추가
            } 
            else if (ch == '>') {
                insideTag = false; // 태그 종료
                sb.append(ch); // '>' 추가
            } 
            else if (insideTag) { 
                // 태그 내부라면 그대로 추가
                sb.append(ch);
            } 
            else {
                if (ch == ' ') { 
                    // 공백을 만나면 스택 비우기
                    while (!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(ch); // 공백 추가
                } else { 
                    stack.push(ch);
                }
            }
        }

        // 마지막 남은 단어 뒤집어서 추가
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
