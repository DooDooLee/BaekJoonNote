
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		int n = Integer.parseInt(br.readLine());
		int num = 0;
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i =0; i<n; i++) {
			int a = Integer.parseInt(st.nextToken());
			boolean isPrime = true;
			
			if(a==0||a==1) {
				isPrime = false;
			}
			
			for(int j = 2; j*j <= a; j++) {
				
				if(a%j==0) {
					isPrime = false;
					break;
				}
			}
			if(isPrime) num++;
			
		}
		
		
		System.out.println(num);
		bw.flush();
		bw.close();
		br.close();

	
		
		
		
		
	}
}
	
