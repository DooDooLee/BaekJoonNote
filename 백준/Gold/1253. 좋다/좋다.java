
import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		long arr[] = new long[n];
		for(int i =0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		int result = 0;
		for(int i =0; i<n; i++) {
			int left=0;
			int right=n-1;
			long a = arr[i];
			
				while(left<right) {
					if(left==i) {
						left ++;
						continue;
					}
					if(right ==i) {
						right--;
						continue;
					}
					
					
					long sum = arr[left]+arr[right];
					if(sum==a) {
						result ++;
						break;
					}else if(sum<a) {
						left++;
					}else {
						right--;
					}
					
				}
			}
		
		System.out.println(result);
		br.close();
		
		
		
	}
}
