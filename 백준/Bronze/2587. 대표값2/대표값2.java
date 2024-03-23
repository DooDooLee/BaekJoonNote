import java.util.*;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] intArr= new int[5];
        int sum =0;

        for(int i = 0; i<5; i++){
            int a = sc.nextInt();
            sum += a;
            intArr[i] = a;
        }

        sc.close();

        intArr = Arrays.stream(intArr).sorted().toArray();
        System.out.println(sum/5);
        System.out.println(intArr[intArr.length/2]);

    }
}

