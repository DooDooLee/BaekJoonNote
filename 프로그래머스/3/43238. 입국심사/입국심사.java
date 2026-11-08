class Solution {
    public boolean check(int[] times, long t, int n){
        long sum = 0;
        for(int i =0; i<times.length; i++){
            sum+= t/times[i];
            if(sum>=n) {return true;}
        }
       
        return false;
    }
    
    public long solution(int n, int[] times) {
        long answer = 0;
        long maxT=0;
        for(int i = 0 ; i<times.length; i++){
            maxT = Math.max(maxT,times[i]);
        }
        long right = maxT * n;
        long left = 1;
        
        while(right>=left){
            long mid = (right+left)/2;
            if(check(times, mid, n)){
                right = mid-1;
                answer = mid;
            }else{
                left = mid+1;
            }
        }
        
        
        
        return answer;
        
    }
}