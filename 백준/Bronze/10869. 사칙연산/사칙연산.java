import java.util.*;

public class Main{
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        System.out.printf((a+b)+"\n"+(a-b)+"\n"+(a*b)+"\n"+
                (a/b)+"\n"+(a%b));
    }
}