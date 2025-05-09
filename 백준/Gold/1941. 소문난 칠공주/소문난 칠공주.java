
import java.io.*;
import java.util.*;

public class Main {

	static char [][] arr = new char[5][5];
	static int result =0;
	static int [] dx = new int[] {0,0,-1,1};
	static int [] dy = new int[] {1,-1,0,0};
	
    public static void main(String[] args) throws IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      for(int i =0; i<5;i++) {
    	  String s = br.readLine();
    	  for(int j=0; j<5; j++) {
    		  arr[i][j] = s.charAt(j);
    	  }
      }
      comb(new ArrayList<>(),0,0,0);
      System.out.println(result);
    
    } 
    
    //s 가 4이상인 7개 조합 만드는 함수
    static void comb(List<Integer> selected, int start, int sCount, int yCount) {
    	if(yCount >=4) {
    		return;
    	}
    	
    	
    	if(selected.size()==7) { // 조합 7개가 완성되었고
    		if(sCount>=4) {		// S가 4개이상 있으면
    			if(isC(selected)) { //연결 여부를 확인하고
    				result++; //연결 되었으면 결과를 1증가시킨다
    			}
    		}
    		return; //그리고 재귀를 빠져나온다.
    	}
    	
    	for(int i =start; i<25; i++) {//조합을 뽑는거니깐 재귀호출할떄 start 를 1증가 시켜서 호출
    		int x = i/5;
    		int y = i%5;
    		
    		selected.add(i);
    		
    		
    		if(arr[x][y]=='S') {
    			comb(selected,i+1,sCount+1,yCount);
    		}else {
    			comb(selected,i+1,sCount,yCount+1);
    		}
    		selected.remove(selected.size()-1);
    	} 
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }
    static boolean isC(List<Integer> selected) {
    	int count =1;
    	int [] visited = new int [7];
    	visited[0] = 1;
    	int a = selected.get(0);
    	
    	
    	
    	Queue<Integer> q = new LinkedList<>();
    	q.add(a);
    	
    	while(!q.isEmpty()) {
    		
    		int c = q.poll();
    		int x = c/5;
        	int y = c%5;
        	
    		for(int i =0; i<4; i++) {
        		int nx = x+dx[i];
        		int ny = y+dy[i];
        		int next = nx*5+ny;
        		if(nx>=0&&nx<5&&ny>=0&&ny<5) {
        			if(selected.contains(next)) {
        				if(visited[selected.indexOf(next)]==0) {
        					visited[selected.indexOf(next)] =1;
        					q.offer(next);
        					count++;
        				}
        			}
        		}
        		
        	}
        	
    	}
    	
    	// list.indexOf(요소); -> 요소의 인덱스가 몇번인지 반환
    	// list.contains(요소); ->요소가 존재하는가?
    	
    	
    	
    	return count ==7;
    	
    	
    	
    }
   
}    
    
