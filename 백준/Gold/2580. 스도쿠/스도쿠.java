
import java.io.*;
import java.util.*;

public class Main {
	static int [][] arr = new int [9][9];
	static List<int []> select = new ArrayList<>();
	static int zero;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i =0; i<9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			for(int j=0; j<9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==0) {
					select.add(new int[] {i,j});
				}
			}
		}
		back(0);
		
		
		
		
		
		
	
	}
	
	static void back(int depth) {
		if(depth == select.size()) {
			for(int i=0;i<9;i++) {
				for(int j=0; j<9; j++) {
					sb.append(String.valueOf(arr[i][j]+" "));
					
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
			System.exit(0);
			}
		int x = select.get(depth)[0];
		int y =select.get(depth)[1];
		for(int i=1; i<=9; i++) {
			if(isValid(x,y,i)) {
				arr[x][y] =i;
				back(depth+1);
				arr[x][y] =0;
			}
			
		}
		
		
		
		
	}
	static boolean isValid(int x, int y,int num) {
		for(int i=0; i<9; i++) {
			if(arr[x][i] ==num || arr[i][y]==num) {
				return false;
			}
		}
		int dx = x/3 *3;
		int dy = y/3 *3;
		
		for(int i=0+dx; i<3+dx; i++) {
			for(int j=0+dy; j<3+dy; j++) {
				if(arr[i][j] ==num) {
					return false;
				}
			}
		}
		
		return true;
		
	}
	
	
	
	
}    
    
