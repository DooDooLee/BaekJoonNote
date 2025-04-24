
import java.util.*;
import java.io.*;

public class Main {
	static int m,n,k;
	static int [][] arr;
	static int [][]  visit;
	static int count;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		m=Integer.parseInt(st.nextToken());
		n=Integer.parseInt(st.nextToken());
		k=Integer.parseInt(st.nextToken());
		visit =new int[m+2][n+2];
		arr = new int[m+2][n+2];
	
		
		for(int i=0; i<k; i++) {
			StringTokenizer st1 =new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(st1.nextToken())+1;
			int y1 = Integer.parseInt(st1.nextToken())+1;
			int x2 = Integer.parseInt(st1.nextToken());
			int y2 = Integer.parseInt(st1.nextToken());
			for(int y=y1; y<=y2; y++) {
				for(int x=x1;x<=x2; x++ ) {
					arr[y][x] =1;
				}
			}
		}
		int size =0;
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int y =1; y<=m; y++) {
			for(int x=1; x<=n; x++) {
				count = 0;
				back(y,x);
				if(count >0) {
					al.add(count);
					size++;
				
				}
			}
		}
		Collections.sort(al);
		System.out.println(size);
		
		for(int i: al) {
			System.out.print(String.valueOf(i)+" ");
		}
		br.close();
		
	}
	
	public static void back(int y, int x) {
		
		if(y>m||x>n) {
			return;
		}else if(visit[y][x]==1||arr[y][x]==1)
		{
			return;
			}else {
				count ++;
				visit[y][x]=1;
				if(y>1) {
					if(x>1) {
						back(y+1,x);
						back(y,x+1);
						back(y-1,x);
						back(y,x-1);
						
					}else {
						back(y+1,x);
						back(y,x+1);
						back(y-1,x);
						
					}
					
				}else {
					if(x>1) {
						back(y+1,x);
						back(y,x+1);
						back(y,x-1);
						
					}else {
						back(y+1,x);
						back(y,x+1);
					}
					
				}
			}
		}
	

	
	
	
	
	
	

}
