import java.util.*;

public class Main{
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int H = sc.nextInt();
        int M = sc.nextInt();
        int C = sc.nextInt();

        if(M+(C%60)<60) {
            System.out.println((H + (C / 60)) % 24 + " " + (M + (C % 60)));
        }else System.out.println((H+(C/60)+1)%24+" "+(M+(C%60)-60));

    }
}