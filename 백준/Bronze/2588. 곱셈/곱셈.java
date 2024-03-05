import java.util.*;

public class Main{
    public static void main(String[] arg){
        Scanner scanner = new Scanner(System.in);
        int A = scanner.nextInt();
        String b = scanner.next();
        int [] intArray = new int [3];
        int C = 0;

        for(int i =2 ; i>=0; i-- ){
            C += A*Character.getNumericValue(b.charAt(i))*(int)Math.pow(10, 2 - i);
            System.out.println(A*Character.getNumericValue(b.charAt(i)));
        }
        System.out.println(C);

    }
}