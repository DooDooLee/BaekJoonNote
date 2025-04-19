
import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n  = Integer.parseInt(br.readLine());
		
		int [] node = new int [n+1];  //0~n  (1~n 만 쓸거임)
 		int [] link = new  int [n];  //0~n-1 (1~n-1) 
 		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i =1; i<n; i++) {
			
			link[i] = Integer.parseInt(st.nextToken());
		}
		StringTokenizer st1= new StringTokenizer(br.readLine());
		for(int i =1; i<=n; i++) {
			
			node[i] = Integer.parseInt(st1.nextToken());
		}
		int i =1;
		int sum=0;
		while(i <n) {
			sum =sum+(node[i]*link[i]);
			int j = i+1;
			while(node[i]<node[j]&&j<n) {
				sum = sum+(node[i]*link[j]);
				j++;
			} 
			i=j;
		}
		
		System.out.println(sum);
		br.close();		
		
	}
}