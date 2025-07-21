import java.io.*;
import java.util.*;

public class Main  {
	public static void main(String [] args )throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int [] arr = new int[n];
		int [] count = new int[100001];
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i =0; i<n; i++) {
			arr[i] =  Integer.parseInt(st2.nextToken());
		}
		
		int max = Integer.MIN_VALUE;
		int l =0;
		int r = 0;
		
		
		while(r<n) {
			count[arr[r]]++;
			
			if(count[arr[r]]>k) {
				while(count[arr[r]]>k) {
					count[arr[l]]--;
					l++;
				}
				max = Math.max(max,r-l+1);
			}else {
				max =Math.max(max,r-l+1);
			}
			r++;
		}
		System.out.println(max);
	
	}
}
