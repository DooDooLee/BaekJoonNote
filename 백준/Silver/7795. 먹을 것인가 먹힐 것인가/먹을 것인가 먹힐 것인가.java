import java.util.*;
import java.util.stream.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int x = 0; x<t; x++){
            int n = sc.nextInt();
            int m = sc.nextInt();

            Integer[] a = new Integer[n];
            Integer[] b = new Integer[m];

            for(int i = 0; i<n; i++){
                a[i] = sc.nextInt();
            }
            for(int i = 0; i<m; i++){
                b[i] = sc.nextInt();
            }

            Arrays.sort(a,Collections.reverseOrder());
            Arrays.sort(b,Collections.reverseOrder());
            int pointerA = 0;
            int pointerB = 0;
            int result = 0;

            while(pointerA < n){
                if(pointerB == m) break;
                while(pointerB < m && a[pointerA]<=b[pointerB]){
                    pointerB++;
                }
                result += m - pointerB;
                pointerA++;
            }




            System.out.println(result);



        }




    }
}

