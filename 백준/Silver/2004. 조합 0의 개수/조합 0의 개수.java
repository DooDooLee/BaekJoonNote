
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] input = br.readLine().split(" ");
		long n = Long.parseLong(input[0]);
		long m = Long.parseLong(input[1]);

		int[] two = new int[3];
		int[] five = new int[3];
		
		two[0] = func(n,2);
		two[1] = func(m,2);
		two[2] = func(n-m,2);
		
		five[0] = func(n,5);
		five[1] = func(m,5);
		five[2] = func(n-m,5);
		

		
		two[0] = two[0]-two[1]-two[2];
		five[0] = five[0]-five[1]-five[2];
		
		int ans = Math.min(two[0],five[0]);
		
		if(ans>0) {
			System.out.println(ans);
		}else {
			System.out.println("0");
		}
		
		
		bw.flush();
		bw.close();
		br.close();
}
	

	public static int func(long a,int b) {
		int count = 0;
		while(a>=b) {
			count += a/b;
			a = a/b;
		}
		return count;
	}
	
}
	
