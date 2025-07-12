
import java.io.*;
import java.util.*;


public class Main {
	static int [] sq;
	static int[] num;
	static int[] v;
	static int n,max,min;
	static int[] arr2;
	
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 n = Integer.parseInt(br.readLine());
		num = new int[n];
		v = new int[n-1];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i =0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		int [] arr = new int[4];
		StringTokenizer st2 = new StringTokenizer(br.readLine());

		for(int i =0; i<4; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		int x=0;
		arr2 = new int[n-1];
		
		for(int i=0; i<4; i++) {
			int a = arr[i];
			while(a>0) {
				arr2[x] = i+1;
				x++;
				a--;
			}
		}
		max = Integer.MIN_VALUE;
		min= Integer.MAX_VALUE;
		
		sq = new int[n - 1];

		for(int i =0; i<n-1; i++) {
			dfs(0,i);
		}
		
		
		
		System.out.println(max);
		System.out.println(min);
	}
	public static void dfs(int depth,int x) {
		
		v[x] = 1;
		sq[depth] = arr2[x]; 
		if(depth == n-2) {
			cal();
			v[x]=0;
			return;
		}
		for(int i =0; i<n-1;i++) {
			if(v[i]==0) {
				dfs(depth+1,i);
			}
		}
		v[x]=0;
	}
	
	public static void cal() {
		int sum = num[0];
		for(int i = 0; i<n-1; i++) {
			if(sq[i]==1) {
				sum = sum+num[i+1];
			}else if(sq[i]==2) {
				sum = sum-num[i+1];
			}else if(sq[i]==3) {
				sum = sum*num[i+1];
			}else if(sq[i]==4) {
				sum = sum/num[i+1];
			}
		}
		
		if(sum<min) {
			min = sum;
		}
		if(sum>max) {
			max = sum; 
		}
		
		
	}
}
