
import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		String num = st.nextToken();
		int n = Integer.parseInt(st.nextToken());
		int ans = 0;
        
		for(int i = 0; i<num.length(); i++) {
			int a = num.charAt(i);
			if(a>='0'&&a<='9') {
				a = a - '0';
			}else if(a>='A' && a<='Z') {
				a = a -'A'+10;
			}
			for(int j = i; j<num.length()-1; j++) {
				a *= n;
			}
			ans += a;
		}
		
	
		
		System.out.println(ans);
		
		bw.flush();
		bw.close();
		br.close();
		
		
	}
}
	
