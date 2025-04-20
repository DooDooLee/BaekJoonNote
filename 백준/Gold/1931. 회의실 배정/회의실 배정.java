import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int [][] a = new int[n][2];
        
        for(int i=0; i<n; i++) {
        	StringTokenizer st = new StringTokenizer(br.readLine());
        	a[i][0] = Integer.parseInt(st.nextToken());
        	a[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(a,new Comparator<int[]>() {
        	@Override
        	public int compare(int[] o1, int[] o2) {
        		if(o1[1]==o2[1]) {
        			return o1[0]-o2[0];
        		}else {
        			return o1[1]-o2[1];
        		}
        	}
        	
        });
        
        
        int count =0;
        int end = 0;
        for(int i=0; i<n; i++) {
        	if(a[i][0]>=end) {
        		count++;
        		end = a[i][1];
        	}
        }
        
        System.out.println(count);        
        br.close();
    }
}
