
import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		int left=0;
		int right=0;
		int sum ;
		int result = 0;
		while(right<n) {
			sum=0;
			for(int i = left; i<=right; i++) {
				sum += arr[i];
			}
			if(sum == m) {
				result++;
				right++;
			}else if(sum<m) {
				right++;
			}else {
				left++;
			}
			
			
		}
		System.out.println(result);
		br.close();
		
	}
}
