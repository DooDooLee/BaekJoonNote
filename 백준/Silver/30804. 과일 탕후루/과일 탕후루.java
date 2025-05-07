
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [ ] arr = new int [n +1];
		int count =0;
		int [] arrC = new int[10];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i =1; i<=n; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
			
		}
		
		int left =0;
		int right =0;
		int max = 0;
		while(right<=n) {
			count = 0;
			for(int i =1; i<10; i++) {
				if(arrC[i]!=0) {
					count ++;
					
				}
			}
			
			if(count>2) {
				left++;
				arrC[arr[left]]--;
			}else if(count<=2) {
				max = Math.max(max,right-left);
				right++;
				if(right<=n) {
					arrC[arr[right]]++;
				}
			}
			
			
		}
		System.out.println(max);
		
		
		
	}
}
