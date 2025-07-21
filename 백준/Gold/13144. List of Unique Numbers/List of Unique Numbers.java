
import java.io.*;
import java.util.*;

public class Main  {
	public static void main(String [] args )throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[n];
		for(int i =0;i <n; i++) {
			arr[i]= Integer.parseInt(st.nextToken());
		}
		
		int l =0;
		int r = 0; 
		long count = 0;
		Set<Integer> set = new HashSet<>();
		while(r<n) {
			if(set.contains(arr[r])) {
				set.remove(arr[l]);
				l++;
			}else {
				set.add(arr[r]);
				count += r-l+1;
				r++;
			}
		}
		System.out.println(count);
		br.close();
	
	}
}
