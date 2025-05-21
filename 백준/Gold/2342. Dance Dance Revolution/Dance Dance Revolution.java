
import java.io.*;
import java.util.*;

public class Main {
	

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		ArrayList<Integer> al = new ArrayList<>();
		while(true) {
			int temp = Integer.parseInt(st.nextToken());
			if(temp ==0) {
				break;
			}
			al.add(temp);
		}
		
		
		
		int [][][] dp = new int [al.size()+1][5][5];
		for(int i =0; i<=al.size(); i++) {
			for(int j =0; j<5; j++) {
				for(int k=0; k<5; k++) {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		
		dp[0][0][0] = 0;
		
		
		for(int i =0; i<al.size(); i++) {
			int step = al.get(i);
			for(int j=0; j<5; j++) {
				for(int k=0; k<5; k++) {
					if(dp[i][j][k]==Integer.MAX_VALUE) {
						continue;
					}
					
					if(j!=step) {
						int cost = cost(k,step);
						dp[i+1][j][step] = Math.min(dp[i+1][j][step],dp[i][j][k]+cost);
					}
					if(k!=step) {
						int cost = cost(j,step);
						dp[i+1][step][k] = Math.min(dp[i+1][step][k],dp[i][j][k]+cost);
					}
					
					
					
					
					
				}
			}
		}
		
		int min =Integer.MAX_VALUE;
		for(int j=0; j<5; j++) {
			for(int i =0; i<5; i++) {
				min = Math.min(dp[al.size()][j][i],min);
			}
		}
		System.out.println(min);
		
	}	
	
	
	
	
	
	
	static int cost(int x, int y) {
		if(x==y) {
			return 1;
		}
		
		if(x==0) {
			return 2;
		}
		
		if(x==1) {
			if(y==3) {
				return 4;
			}else {
				return 3;
			}
		}
		
		if(x==2) {
			if(y==4) {
				return 4;
			}else {
				return 3;
			}
		}
		if(x==3) {
			if(y==1) {
				return 4;
			}else {
				return 3;
			}
		}
		if(x==4) {
			if(y==2) {
				return 4;
			}else {
				return 3;
			}
		}
		return Integer.MAX_VALUE;
	}
	
		
}

		
