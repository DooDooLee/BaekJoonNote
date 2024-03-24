import java.util.*;

public class Main{
    public static int binarySearch(Integer[] a, int length, int b) {
        int first = 0;
        int end = length-1;

        while(first<=end){
            int mid = (first+end)/2;
            if(b==a[mid]) return 1;
            else if(b<a[mid]) end = mid-1;
            else if(b>a[mid]) first = mid+1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] a = new Integer[n];

        for(int i = 0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int m = sc.nextInt();
        Integer[] b = new Integer[m];

        for(int i = 0; i<m; i++){
            b[i] = sc.nextInt();
        }
        sc.close();
        Arrays.sort(a);

        for(int i = 0; i<m; i++){
           System.out.println(binarySearch(a,n,b[i]));
        }

    }



}


