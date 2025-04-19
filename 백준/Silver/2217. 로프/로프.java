
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer [] g = new Integer [n];
        
        for(int i=0; i<n; i++) {
        	g[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(g,Collections.reverseOrder());

        int sum = 0;
        int m = 1;
        for(int i=0; i<n; i++) {
        	if(sum<=g[i]*m) {
        		sum = g[i]*m;
        	}
        	m++;
        }
        
        System.out.println(sum);
        br.close();
    }
}
