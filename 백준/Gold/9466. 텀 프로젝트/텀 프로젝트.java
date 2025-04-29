
import java.io.*;
import java.util.*;

public class Main {
	static int[] arr;
	static int[] visit;
	static int[] team;
	public static void main(String[] args)throws IOException {

	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		while(t-- >0) {
			int n = Integer.parseInt(br.readLine());
			arr= new int[n+1];
			team = new int[n+1];
			visit = new int[n+1];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 1; i<=n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			for(int i=1; i<=n; i++) {
				if (team[i] == 0&&visit[i]==0) {
			        dfs(i);
			    }
			}
			int count =0;
			for(int i=1; i<=n; i++) {
				if(team[i]==0) {
					count++;
				}
			}
			System.out.println(count);
			
			
		}
		br.close();
	}
		
	static int dfs(int x) {
		
		if(visit[x]==0&& team[x] == 0) {
			visit[x]=1;
			int a = dfs(arr[x]);
			visit[x]=2;
			if(a==0) {
				return 0;
			}else if(a==x) {	
				team[x]=1;
				return 0;
			}else {
				team[x]=1;
				return a;
			}
		}else if(visit[x]==1&& team[x] == 0) {
			team[x] =1;
			visit[x]=2;
			return arr[x];
		}
		
		return 0;
	}
}
