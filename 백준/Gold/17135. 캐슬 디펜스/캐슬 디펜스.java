
import java.io.*;
import java.util.*;

public class Main {
	static int  map[][];
	static int m,n,d;
	static int Max = Integer.MIN_VALUE;
	static ArrayList<int []> enemy;
	static int [] isShot;

    public static void main(String[] args)throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		enemy = new ArrayList<>();
		map = new int[n][m];
		
		
		for(int i=0;i<n;i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				map[i][j] = Integer.parseInt(st2.nextToken());
				if(map[i][j]==1) {
					enemy.add(new int[] {i,j});
				}
			}
		}
		
		
		
		
		for(int i =0; i<m-2; i++) {
			for(int j=i+1; j<m-1; j++) {
				for(int k=j+1; k<m; k++) { //3중포문으로 조합뽑음
					isShot = new int[enemy.size()]; // 맞은 적 배열 초기화
					shot(i,j,k); //함수 실행
					int count = 0;
					for(int l : isShot) { // 1이면 쏜거니깐
						if(l==1) count++; // 카운팅해주시고
					}
					
					Max = Math.max(Max,count);
					
				}
			}
		}
		
		System.out.println(Max);
    }
    
    public static int choice(int y,int depth) {
    	boolean isC = false;
    	int minI = 999; 
    	
    	int minD = Integer.MAX_VALUE;
    	for(int i=0; i<enemy.size(); i++) {
    		int[] a = enemy.get(i); 
    		int ex = a[0];
    		int ey = a[1];
    		if(ex+depth<n) {
    			int distance = Math.abs(ex+depth-(n)) + Math.abs(ey-y); //거리 계산
        		
        		if(distance<=d && distance <= minD &&isShot[i]!=1) { //거리가 범위안에있고 짧으며 원래 맞은적이 아니면(제거된적이아니면)
        			if(minD == distance) {
        				if(minI!=999) {
        					if(enemy.get(minI)[1]>ey) {
        						minI = i;
        						minD = distance;
        						isC = true;
        					}
        				}
        			}else {
        				minI = i;
						minD = distance;
						isC = true;
        			}
        			
        		}  		
    		} //만약 이동한 적이 성에 닿았으면 그건 무시(다 이동한걸로 침, 이것으로 이동하는건 구현이됨)
    		
    	}
    	
    	if(isC) {	
    		return minI; //minI  인덱스를 반환함
    	}
    	
    	return 99999;
    	
    }
    
    
    
    public static void shot(int a, int b, int c) {
    	for(int depth = 0 ; depth<n; depth ++) {
    		int sa =choice(a,depth);     // 쏜인덱스를 받음		
    		int sb =choice(b,depth); 		
    		int sc =choice(c,depth);
    		//다쏘고나서 isShot을 갱신함 이렇게하면 동시에 쏜다는게 구현이됨
    		if(sa!=99999) {
    			isShot[sa]=1; //그 인덱스를 쐇다고 바꿈
    		}
    		if(sb!=99999) {
    			isShot[sb]=1;
    		}
    		if(sc!=99999) {
    			isShot[sc]=1;
    		}
    	} //이렇게되면 궁수 세명이 각자 같은 사람을 쐇을수도잇고 뭐 재각기 다른사람을 쏠수있는걸 이렇게 구현이가능하다 배열로 자고로 99999값을 리턴햇다는것은 아무도 안쐇다는뜻
    	
    }
    
    
    
    
}