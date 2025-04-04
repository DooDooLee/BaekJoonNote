
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		
		int a1 = calc(a,b);
		int a2 = a*b/a1;
		
		System.out.println(a1);
		System.out.println(a2);
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	public static int calc(int a, int b) {
		if(a%b ==0) {
			return b;
		}else {
			return calc(b,a%b);
		}
		
}
	

}