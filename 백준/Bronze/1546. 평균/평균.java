import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        float avg = 0;
        float sum = 0;

        count = scanner.nextInt();
        int[] intArray = new int[count];

        for(int i = 0; i<count; i++){
            intArray[i] = scanner.nextInt();
        }

        Arrays.sort(intArray);

        for(float i : intArray){
            sum += (i / intArray[count -1]) * 100;
        }
        avg = sum/count;

        System.out.println(avg);



        scanner.close();


    }
}
