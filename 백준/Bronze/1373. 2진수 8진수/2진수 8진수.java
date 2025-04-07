import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String binary = br.readLine();
        StringBuilder sb = new StringBuilder();

        // 앞자리를 3의 배수로 맞추기 위해 0 채워주기
        int len = binary.length();
        int mod = len % 3;
        if (mod == 1) binary = "00" + binary;
        else if (mod == 2) binary = "0" + binary;

        // 3자리씩 끊어서 8진수로 변환
        for (int i = 0; i < binary.length(); i += 3) {
            String part = binary.substring(i, i + 3);
            int num = (part.charAt(0) - '0') * 4
                    + (part.charAt(1) - '0') * 2
                    + (part.charAt(2) - '0');
            sb.append(num);
        }

        // 정규표현식 대신 앞자리 0 제거 직접 구현
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i++;
        }
        System.out.println(sb.substring(i));
    }
}
