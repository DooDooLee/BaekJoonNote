
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int [] gap = new int[N];
		
		for(int i = 0; i<N; i++) {
			gap[i] = Math.abs(Integer.parseInt(st2.nextToken())-S);
		}
		
		
		if(N>1) {
			int D = gcd(gap[0],gap[1]);
			for(int i = 2; i<N; i++) {
				D = gcd(D,gap[i]);
		}
			bw.write(String.valueOf(D));
		
		}else if(N!=S) {
			bw.write(String.valueOf(gap[0]));
		}else {
			int D = Math.max(Math.abs(1000000000-S),Math.abs(S-1));
			bw.write(String.valueOf(D));
		}
		
		
		

		bw.flush();
		bw.close();		
		br.close();	
	}	
	
	
	
	
	
	
	
	
	
	
	
	public static int gcd(int a, int b) {
		while(b != 0) {
			int temp = b;
			b = a%b;
			a = temp;	
		}
		return a;
	}
}
	