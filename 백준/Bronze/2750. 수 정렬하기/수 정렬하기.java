

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int key,j = 0;

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            array[i] = sc.nextInt();
        }

        for (int i = 1; i < size; i++) {
            key = array[i];
            j = i-1;
            while(j>=0 && array[j]>key){
                array[j+1] = array[j];
                j--;
                }
            array[j+1] = key;
            }

        for (int a : array){
            System.out.println(a);}

        sc.close();
        }
    }



