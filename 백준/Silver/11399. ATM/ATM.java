
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] a =new int[n];
		for(int i =0; i<n; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(a);
		int sum = 0;
		for(int i =0; i<n; i++) {
			for(int j=i; j>=0; j--) {
				sum += a[j];
			}
			
		}
		
		System.out.println(sum);
		br.close();		
		
	}
}