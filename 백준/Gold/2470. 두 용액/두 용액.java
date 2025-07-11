
import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		long [] arr = new long[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int left =0;
		int right=n-1;
		Arrays.sort(arr);
		int a=0;
		int b=0;
		long sum = 0;
		long[] result = new long[2];
		long min = Long.MAX_VALUE;
		while(left<right) {
			sum = 0;
			sum = arr[left]+arr[right];
			if(Math.abs(sum)<min) {
				a=left;
				b=right;
				min = Math.abs(sum);
			}
			if(sum<0) {
				left++;
			}else if(sum>0) {
				right--;
			}else {
				break;
			}
			
		}
		System.out.println(arr[a]+" "+arr[b]);
		br.close();
	}
}
