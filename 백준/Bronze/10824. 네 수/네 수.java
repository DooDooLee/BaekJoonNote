import java.util.*;
import java.io.*;

class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String arr[] = new String[2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		arr[0] = st.nextToken()+st.nextToken();
		arr[1] = st.nextToken()+st.nextToken();
		
		long result = Long.parseLong(arr[0]) + Long.parseLong(arr[1]);
		
		bw.write(String.valueOf(result));
		
		bw.flush();
		bw.close();
		br.close();
	}
}