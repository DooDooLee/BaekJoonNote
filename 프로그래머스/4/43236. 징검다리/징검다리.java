import java.util.*;
import java.io.*;

class Solution {
    public int solution(int distance, int[] rocks, int n)throws IOException {
        int answer = 0;
        Arrays.sort(rocks);
        
        //이분탐색 l = 1   r =  distance 실행
        int l = 1;
        int r = distance;
        while(l<=r){
            
            int m = (l+r)/2;
            int erase = 0;
            int cPos = 0;
            int cDist = 0;
            int currentD = 0;
            boolean isP = true;
            for(int i = -1; i< rocks.length; i++){
                
                if(i==-1){
                   currentD = rocks[0];
                }else if(i== rocks.length-1){
                    currentD = distance - cPos;
                }else{
                    currentD = rocks[i+1] -cPos;
                }
                
                if(currentD < m){
                   erase++;
                }else{
                    if(i<rocks.length-1){
                        cPos = rocks[i+1];
                    }
                }
                
                if(erase > n){
                    isP = false ;
                    break;
                }
            }
            
            if(isP){
                answer = Math.max(answer,m);
                l = m+1;
            }else{
                r = m-1;
            }
        }
        
        System.out.println(answer);
        return answer;
    }
}