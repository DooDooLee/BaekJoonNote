import java.io.*;
import java.util.*;

public class Main {
	static int [] priority ;
	static int[] num;
	static char[] cal;
	static int n;
	static int max;
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		n = Integer.parseInt(br.readLine());
		String a = br.readLine();
		num = new int[n/2+1];
		cal = new char[n/2];
		priority = new int[n/2];
		max = Integer.MIN_VALUE;
		int ni =0;
		int ci=0;
		for(int i =0; i<n; i++) {
			
			if(i%2 ==0) {
				num[ni] = Integer.parseInt(String.valueOf(a.charAt(i)));	
				ni++;
			}else {
				cal[ci] = a.charAt(i);
				ci++;
			}
		}
		
		
		dfs(0);
		System.out.println(max);
		
		
		
		
		
		
		
	}
	
	static void calc() {
		Deque <Integer> st1 = new LinkedList<>();
		Deque <Character> st2 = new LinkedList<>();
		st1.addLast(num[0]);
		int ni =1;
		int ci =0;
		
		while(true) {
			if(ni>=num.length || ci>=cal.length) break;
			st1.addLast(num[ni]);
			st2.addLast(cal[ci]);
			if(priority[ci]==1) {
				char c = st2.pollLast();
				if(c=='+') {
					st1.addLast(st1.pollLast()+st1.pollLast());
				}else if(c=='-') {
					int b = st1.pollLast();
					int a = st1.pollLast();
					st1.addLast(a - b); 
				}else {
					st1.addLast(st1.pollLast()*st1.pollLast());
				}
			}
			ni++;
			ci++;
		}
		while(!st2.isEmpty()) {
			char c = st2.pollFirst();
			if(c=='+') {
				st1.addFirst(st1.pollFirst()+st1.pollFirst());
			}else if(c=='-') {
				int a = st1.pollFirst();
				int b = st1.pollFirst();
				st1.addFirst(a - b); 
			}else {
				st1.addFirst(st1.pollFirst()*st1.pollFirst());
			}
		}
		max = Math.max(max, st1.pollLast());
			
		
		
	}
	
	
	static void dfs(int index) {
		
		if(index>n/2-1) {
			calc();
			return;
		}
		
		dfs(index+1);
		priority[index] =1;
		dfs(index+2);
		priority[index] =0;
	}
	
	
}