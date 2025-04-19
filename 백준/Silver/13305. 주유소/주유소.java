
import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		
		int [] node = new int [n+1];  // 기름값
 		int [] link = new  int [n];   // 거리

 		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i < n; i++) {
			link[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= n; i++) {
			node[i] = Integer.parseInt(st.nextToken());
		}

		int i = 1;
		long sum = 0;

		while(i < n) {
			long cost = node[i];
			int j = i;
			long distSum = link[j];

			while(++j < n && node[j] > cost) {
				distSum += link[j];
			}

			sum += cost * distSum;
			i = j;
		}

		System.out.println(sum);
		br.close();		
	}
}
