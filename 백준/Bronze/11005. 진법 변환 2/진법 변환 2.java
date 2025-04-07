
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		
		int n = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		func(sb,n,b);
		System.out.println(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	
	public static void func(StringBuilder sb, int n, int b) {
		int temp = n;
		n = n/b;
		if(n>=b) {
			func(sb,n,b);
		}else {
			if(n>=10) {
				char a = (char)(n+55);
				sb.append(a);
			}else if(n>0){sb.append(String.valueOf(n));}
		}
		
		if( (temp%b)>=10) {
			char x = (char)((temp%b)+55);
			sb.append(x);
		}else {sb.append(String.valueOf((temp%b)));}
		
	}
}
	
