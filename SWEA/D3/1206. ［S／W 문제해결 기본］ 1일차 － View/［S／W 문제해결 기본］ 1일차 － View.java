import java.io.BufferedReader;
import java.io.InputStreamReader;
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int p = 1; p<=10; p++){
            int size = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");
            int sum = 0;
            int[] a = new int[size];
            for(int i = 0; i<size; i++){
                a[i] = Integer.parseInt(tokens[i]);
            }
            for(int j = 2; j < size - 2; j++) {
                if(a[j] > a[j-1] && a[j] > a[j+1] && a[j] > a[j-2] && a[j] > a[j+2] ) {
                    sum += a[j]-Math.max(Math.max(a[j-1],a[j+1]),Math.max(a[j-2],a[j+2]));
                }
            }
            System.out.println("#"+p+" "+sum);
        }
    }
}
