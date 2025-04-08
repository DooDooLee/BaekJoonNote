
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		

		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		int i = 2;
		while(n>1) {
			if(n%i==0) {
				n=n/i;
				sb.append(String.valueOf(i));
				sb.append("\n");
			}else {
				i++;
			}
		}
		
		
		System.out.println(sb.toString());
		
		bw.flush();
		bw.close();
		br.close();

	
		
		
		
		
	}
}
	
