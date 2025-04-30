
import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> al;
	public static void main(String[] args)throws IOException {
	al = new ArrayList<>();
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int n = Integer.parseInt(br.readLine());
	StringTokenizer st = new StringTokenizer(br.readLine());

	al.add(Integer.parseInt(st.nextToken()));
	
	for(int i = 1; i<n; i++) {
		int a = Integer.parseInt(st.nextToken());
		if(al.get(al.size()-1)<a) {
			al.add(a);
		}else {
			int idx = bin(a);
			al.set(idx, a);
		}
	}
	
	
	System.out.println(al.size());
	
	
	
	br.close();
	
	}
	static int bin(int a) {
		int left = 0;
		int right = al.size();
		
		while(right>=left) {
			int  mid = (left+right)/2;
			if(a>al.get(mid)) {
				left = mid+1;
			}else if(al.get(mid) == a){
				return mid;
			}else {
				right = mid-1;
			}
		}
		
		
		return left;
	}
}
