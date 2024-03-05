import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int [] intArray = new int[a];
        int max = 0;
        int min = 0;
        for(int i=0; i<a; i++){
            intArray[i] = scanner.nextInt();
        }

        max = intArray[0];
        min = intArray[0];

        for(int i=0; i<a; i++){
            if(intArray[i] >= max) max =intArray[i];
            if(intArray[i] <= min) min =intArray[i];
        }

        System.out.println(min+" "+max);



        scanner.close();
    }
}
