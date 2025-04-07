import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args)throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); 
		int s = Integer.parseInt(st.nextToken()); 
		int [] arr = new int[n];
		
		StringTokenizer st2 = new StringTokenizer(br.readLine()); 
		
		arr[0] = Integer.parseInt(st2.nextToken()); 
		int min = 0;
		
		for(int i = 1; i<n; i++) {
			arr[i]= Integer.parseInt(st2.nextToken()); 
			if(Math.abs(arr[min]-s)>Math.abs(arr[i]-s)) {
				if(arr[i]!=s) 
				min = i;
				}
		}
		
		int gap = Math.abs(s-arr[min]);
		
		
		boolean isAnswer = false;
		
			if(n==1&&n==s) {
				gap = Math.max(Math.abs(1000000000-s),Math.abs(s-1));
				bw.write(String.valueOf(gap));
			}else {
				while (gap > 1) {
					isAnswer = true;
					for (int i = 0; i < n; i++) {
						if (Math.abs(arr[i] - s) % gap != 0) {
							isAnswer = false;
							break;
						}
					}
					if (isAnswer) break;
					gap--;
				}
				bw.write(String.valueOf(gap));
			}
			
		
		
		

		bw.flush();
		bw.close();		
		br.close();	
	}	
}
	
