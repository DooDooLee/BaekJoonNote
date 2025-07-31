import java.util.*;
import java.io.*;
public class Main {
	public static void main(String [] args) throws IOException {
		
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int [] arr= new int[n+1];
		int [][] dp1 =new int[n+1][2];
		int [][] dp2 =new int [n+1][2];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i<=n; i++) {
			
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=n-1; i>0; i--) {
			int pi = i+1;
				
			while(pi<=n) {
				if(arr[i]<arr[pi]) {
					dp1[i][0] += dp1[pi][0]+1;
					dp1[i][1] = pi;
					break;
				}
				pi++;
			}
			
			
		}
		
		for(int i =2; i<=n; i++) {
			int pi = i-1;
			while(pi>0) {
				if(arr[i]<arr[pi]) {
					dp2[i][0] += dp2[pi][0]+1;
					dp2[i][1] = pi;
					break;
				}
				pi--;
			}
			
		}
		
		for(int i =1; i<=n; i++) {
			if(dp1[i][0]==0&&dp2[i][0]==0) {
				System.out.println("0");
			}else if(dp1[i][0]!=0 && dp2[i][0]==0 ) {
				System.out.println(dp1[i][0]+" "+dp1[i][1]);
			}else {
				if(Math.abs(i-dp2[i][1])<=Math.abs(i-dp1[i][1])) {
					System.out.println(dp2[i][0]+dp1[i][0]+" "+dp2[i][1]);
				}else {
					System.out.println(dp2[i][0]+dp1[i][0]+" "+dp1[i][1]);
				}
				
			}
		}
		
		

		
		
		
		
	}
}
