import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int index = 0;

        String word = scanner.next();
        int[] alphabet = new int[26];


        Arrays.fill(alphabet, -1);

        for(int i =0; i<word.length(); i++){
            index = word.charAt(i)-'a';
            if(alphabet[index]==-1)
                alphabet[index] = i;
        }

        for(int i : alphabet){
            System.out.printf("%d ",i);
        }



    }
}
