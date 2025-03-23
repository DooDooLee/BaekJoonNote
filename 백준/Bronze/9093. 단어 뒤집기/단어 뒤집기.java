import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader로 입력 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // BufferedWriter로 출력 최적화
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while(T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder lineBuilder = new StringBuilder();  // 한 줄에 대한 StringBuilder

            while(st.hasMoreTokens()){
                // 단어 뒤집기 후 lineBuilder에 추가
                lineBuilder.append(new StringBuilder(st.nextToken()).reverse().toString()).append(" ");
            }
            // 한 줄 출력
            bw.write(lineBuilder.toString() + "\n");  // 마지막 공백을 제거하고 개행 추가
        }

        // 버퍼에 있는 모든 내용 출력
        bw.flush();
    }
}
