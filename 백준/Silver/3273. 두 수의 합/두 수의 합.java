
import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int [n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int b = Integer.parseInt(br.readLine());
		
		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		Arrays.sort(arr);
		
		int left=0;
		int right = n-1;
		int count = 0;
		while(left<right) {
			int temp = arr[left] + arr[right];
			if(temp >b) {
				right --;
			}else if(temp<b) {
				left++;
			}else if(temp ==b) {
				right--;
				left++;
				count++;
			}
		}
		System.out.println(count);
		
		
		
	}
	
	
	
		
}

		
