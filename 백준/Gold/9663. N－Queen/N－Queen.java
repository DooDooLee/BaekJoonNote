
import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int [][] arr;
	static int result = 0;
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		arr= new int[n][n];
		
		for(int i=0; i<n;i++) {
			Arrays.fill(arr[i],0);
		}
	
		
		back(0,0);
		
		System.out.println(result);
		
		
		
		
		
		
	}	
	
	static void back(int start,int depth) {
		if (depth == n) {
		   
		  
		    result++;
		    return;
		}
		for(int i=start; i<start+n;i++) {
			int x = i/n;
			int y = i%n;
			if(isValid(x,y)) {
				arr[x][y]=1;
				int num = (x+1)*n;
				back(num ,depth+1);
				arr[x][y]=0;
			}
			
		}
		
		
		
		
	}
	
	static boolean isValid(int x,int y) {
		for(int i=0;i<n;i++) {
			if(arr[i][y]==1) {
				return false;
			}
		}
		
		int tx =x+1; int ty=y+1;
		
		while(tx <n&&ty<n) {
			if(arr[tx][ty]==1) {
				return false;
			}
			tx++;
			ty++;
		}
		
		tx = x-1;
		ty = y-1;
		while(tx >=0&&ty>=0&&ty<n&&tx <n) {
			if(arr[tx][ty]==1) {
				return false;
			}
			tx--;
			ty--;
		}
		
		tx = x+1;
		ty = y-1;
		while(tx >=0&&ty>=0&&ty<n&&tx <n) {
			if(arr[tx][ty]==1) {
				return false;
			}
			tx++;
			ty--;
		}
		tx = x-1;
		ty = y+1;
		while(tx >=0&&ty>=0&&ty<n&&tx<n) {
			if(arr[tx][ty]==1) {
				return false;
			}
			tx--;
			ty++;
		}
		
		
		
		return true;
	}
	
	
	
}    
    
