
import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<ArrayList <int[]>> al;
	public static void main(String[] args)throws IOException {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 int n = Integer.parseInt(br.readLine());
		 int [] d =new int[n+1];
		 Arrays.fill(d,Integer.MAX_VALUE);
		 al = new ArrayList<>();
		 int m = Integer.parseInt(br.readLine());
		 for(int i =0; i<=n; i++) {
			 al.add(new ArrayList<>());
		 }
		 
		 for(int i =0; i<m; i++) {
			 StringTokenizer st = new StringTokenizer(br.readLine());
			 int x = Integer.parseInt(st.nextToken());
			 int y = Integer.parseInt(st.nextToken());
			 int w = Integer.parseInt(st.nextToken());
			 
			 al.get(x).add(new int[] {y,w});
		 }
		 
		 
		 StringTokenizer st2 = new StringTokenizer(br.readLine());
		 int start =  Integer.parseInt(st2.nextToken());
		 int end = Integer.parseInt(st2.nextToken());
		 
		 Queue<int []> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
		 
		 
		 pq.add(new int[] {start,0});
		 
		 while(!pq.isEmpty()) {
			 int[] temp = pq.poll();
			 int x = temp[0];
			 int w= temp[1];
			 if(x==end) {
				 if(d[x]>w) {
					 d[x]=w;
				 }
				 continue;
			 }
			 if(d[x]>w) {
				 d[x] =w;
				 for(int[] bus:al.get(x)) {
						int y = bus[0];
						int ww = bus[1];
						pq.add(new int[] {y,w+ww});
					}
			 }
		 }
		 System.out.println(d[end]);
		 
		 
	}
		
}

		
