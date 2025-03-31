import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 피연산자 개수
        String expression = br.readLine(); // 후위 표기식
        
        Map<Character, Double> values = new HashMap<>();
        for (int i = 0; i < n; i++) {
            values.put((char) ('A' + i), Double.parseDouble(br.readLine()));
        }
        
        Stack<Double> stack = new Stack<>();
        for (char c : expression.toCharArray()) {
            if (Character.isAlphabetic(c)) { // 피연산자라면
                stack.push(values.get(c));
            } else { // 연산자라면
                double b = stack.pop();
                double a = stack.pop();
                switch (c) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }
        
        System.out.printf("%.2f", stack.pop());
    }
}
