
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args)throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	StringTokenizer st = new StringTokenizer(br.readLine());
	long [] arr = new long[n];
	
	for(int i =0; i<n; i++) {
		arr[i] = Long.parseLong(st.nextToken());
	}
	
	
	int left = 0;
	int right = n-1;
	int [] minIndex = new int[2];
	long min = Long.MAX_VALUE;
	
	while(left<right) {
		long temp = arr[left] + arr[right];
		if(temp ==0) {
			minIndex[0] =left;
			minIndex[1] = right;
			break;
		}
		
		if(min>Math.abs(temp)) {
			min = Math.abs(temp);
			minIndex[0] =left;
			minIndex[1] = right;
		}
		if(temp>0) {
			right--;
		}else {
			left++;
		}
		
		
	}
	System.out.println(arr[minIndex[0]]+" " +arr[minIndex[1]]);
	
	}
		
}

		
