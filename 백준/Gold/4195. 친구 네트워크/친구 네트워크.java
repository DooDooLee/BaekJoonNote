
import java.io.*;
import java.util.*;

public class Main {
	static int []set;
	static Map<String,String> map;
	 static Map<String, Integer> size; 
	public static void main(String[] args)throws IOException {
		{BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

			int t = Integer.parseInt(br.readLine());
			while(t-->0) {
				int f = Integer.parseInt(br.readLine());
				map = new HashMap<>();
				size = new HashMap<>();
				while(f-->0) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					String a = st.nextToken();
					String b = st.nextToken();
					
					if(map.get(a)==null) {
						map.put(a,a);
						size.put(a,1);
					}
					if(map.get(b)==null) {
						map.put(b,b);
						size.put(b,1);
					}
					union(a,b);
					
					
					System.out.println(size.get(find(b)));
					
					
					
				}
				
			}
			
		}
	}
	static void union(String a, String b) {
		String rootA = find(a);
		String rootB = find(b);
		 if (!rootA.equals(rootB)) {
		        int t = size.get(rootA) + size.get(rootB);
		        map.put(rootA, rootB);        // rootA를 rootB 밑으로
		        size.put(rootB, t);           // rootB가 새로운 루트니까 size 갱신
		    }
		
	}
	static String find(String a) {
		if(!map.get(a).equals(a)) {
			map.put(a,find(map.get(a)));	
		}
		return map.get(a);
	}
	
}    
    
