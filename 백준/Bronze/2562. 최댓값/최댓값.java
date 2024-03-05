import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = -1;
        int count = 1;
        int max_c = 1;

        while(scanner.hasNext()){
            int a = scanner.nextInt();

            if (a>max) {
                max = a;
                max_c=count;
            }
            count++;
        }

        scanner.close();

        System.out.println(max+"\n"+max_c);
    }
}
