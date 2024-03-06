import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [][] intArray =new int [9][9];
        int max =-1;
        int index1= 0;
        int  index2 =0;

        for(int i =0; i<9; i++){
            for(int j= 0; j<9; j++){
                intArray[i][j] = sc.nextInt();
            }
        }

        for(int i =0; i<9; i++){
            for(int j= 0; j<9; j++){
                if (intArray[i][j]>max){
                    max =intArray[i][j];
                    index1 = i+1;
                    index2 = j+1;
                }
            }
        }

        System.out.println(max+"\n"+index1+" "+index2);


    }
}
