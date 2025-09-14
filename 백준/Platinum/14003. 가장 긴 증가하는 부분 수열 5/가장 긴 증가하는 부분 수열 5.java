
import java.util.*;
import java.io.*;

public class Main {
    static int n;
    static int[] arr;
    static ArrayList<Integer> tails;
    static int[][] follow;
    static int max = 0;
    public static void main(String[] arg) throws IOException {
    	//System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i =0; i<n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        //테일즈 배열 만들고
        //끝 값보다 크면 뒤에 추가
        //끝값보다 값이 작으면 이진탐색 시작
        //탐색후 해당하는 위치(인덱스)를 추적배열에 기록 
        //추적 배열에 들어갈 값이 max면은 갱신
        
        //다 끝나고 추적 베열의 max값을 찾고 거기서부터 인덱스를 차례대로 역추적
        
        follow = new int[n][2];
        tails = new  ArrayList<>();
        
        tails.add(arr[0]);
        follow[0][0] = arr[0];
        follow[0][1]=0;
        int rI = 0;
       
        for(int i =1; i<n; i++) {
        	int x = arr[i];
        	if(tails.get(tails.size()-1)<x) {
        		tails.add(x);
        		follow[i][0] = x;
        		follow[i][1] =max+1;
        		max = follow[i][1];
        		rI =  i; //역추적 수열이 시작되는 인덱
        	}else {
        		int index = binary(x);
        		tails.set(index, x);
        		follow[i][0] = x;
        		follow[i][1] =index;
        		max = Math.max(max, follow[i][1]);
        		if(max == follow[i][1]) {
        			rI =i;//역추적 수열이 시작되는 인덱
        		}
        	}
        	
        	
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(tails.size()).append("\n");
        
        int [] result = new int[tails.size()];
        result[0] = follow[rI][0];
        max--;
        
        int index = 1;
        
        for(int i= rI-1; i>=0; i--) {
        	if(follow[i][1]==max) {
        		result[index] = follow[i][0];
        		max--;
        		index++;
        	}
        }
        for(int i = result.length-1; i>=0; i--) {
        	sb.append(result[i]+" ");
        }
        
        System.out.println(sb.toString());
    }
    
    
    public static int binary(int x) {
    	int r = tails.size()-1;
    	int l = 0;
    	
    	
    	
    	while(l<r) {
    		int m=(r+l)/2;
    		if(tails.get(m)<x) {
    			l=m+1;
    			
    		}else if(x<=tails.get(m)) {
    			r=m;
    		}
    		
    	}
    	return r;
    }
}