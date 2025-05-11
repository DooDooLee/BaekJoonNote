
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static ArrayList<String[]> d = new ArrayList<>();
	static ArrayList<ArrayList<int[]>> al = new ArrayList<>();
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m  = Integer.parseInt(br.readLine());
		for(int i =0;i<=n;i++) {
			al.add(new ArrayList<>());
			d.add(new String[] {String.valueOf(Integer.MAX_VALUE), ""});

		}
		
		
		for(int i =0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a= Integer.parseInt(st.nextToken());
			int b= Integer.parseInt(st.nextToken());
			int c= Integer.parseInt(st.nextToken());
			
			
			al.get(a).add(new int[] {b,c});
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st2.nextToken());
		int e = Integer.parseInt(st2.nextToken()); 
		
		
		Queue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]); // [0]에는 도착지 [1]에는 비용
		pq.add(new int[] {s,0});
		d.get(s)[0]="0";
		d.get(s)[1]=String.valueOf(s);
		
		while(!pq.isEmpty()) {
			int [] cur = pq.poll();
			int c = cur[0];
			int w = cur[1];
			if(Integer.parseInt(d.get(c)[0])<w) {
				continue;
			}
			for(int[] i : al.get(c)) {
				int nn= i[0];
				int nw = i[1]+w;
				
				if(Integer.parseInt(d.get(nn)[0])>nw) {
					d.get(nn)[1] = d.get(c)[1] +" "+ String.valueOf(nn);
					d.get(nn)[0] = String.valueOf(nw);
					pq.add(new int[] {nn,nw});
				}
			}
			
		}
		
		StringTokenizer st3 = new StringTokenizer(d.get(e)[1]);
		int  size = st3.countTokens();
		System.out.println(d.get(e)[0]);
		System.out.println(size);
		

		
		for(int i =0; i<size; i++) {
			System.out.print(st3.nextToken()+" ");
		}
		
		
	}
	
	
	
}    
    
