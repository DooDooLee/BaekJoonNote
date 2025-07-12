
import java.io.*;
import java.util.*;


public class Main {
	static List<Integer> list;
	static int n, m;
	static int[] ans;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); //4
		m = Integer.parseInt(st.nextToken()); //4
		Set <Integer>set = new HashSet<>();
		ans = new int [m]; 
		
		StringTokenizer st2 = new StringTokenizer(br.readLine()); // 1 1 2 2

		for(int i = 0; i<n; i++) {
			set.add(Integer.parseInt(st2.nextToken()));	
		}
		
		list = new ArrayList<>(set);
		
		Collections.sort(list); 
		
		
		
		angGimoDDI(0,0);
		
		br.close();
		
		
		
		
		
	}
	static void DiddyParty() {
		for(int BabyOil = 0; BabyOil<m; BabyOil++) {
			System.out.print(ans[BabyOil]+" ");
		}
		System.out.println();
	}
	
	static void angGimoDDI(int diddy,int puff ){
		if(diddy == m) {
			DiddyParty();
			return;
		}
		
		for(int i =puff; i<list.size();i++) {
			ans[diddy] = list.get(i); 
			angGimoDDI(diddy+1,i);
		}
		
		
	}
}

