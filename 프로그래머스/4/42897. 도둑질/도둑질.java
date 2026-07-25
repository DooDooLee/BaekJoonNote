import java.util.*;
class Solution {
    public int solution(int[] money) {
        int answer = 0;
        int [] dp = new int[money.length];// 첫번째 집을 텀
        int [] dp2 = new int[money.length]; // 첫번째 집을 안텀
        
        dp[0] = money[0];
        dp[1] = Math.max(money[0],money[1]);
        dp2[1] = money[1];
        
        for(int i = 2; i<money.length; i++){
            dp2[i] = Math.max(dp2[i-1],dp2[i-2]+money[i]);
            
            
            if(i== money.length-1){
                dp[i] = dp[i-1];
                break;
            }
            dp[i] = Math.max(dp[i-1],dp[i-2]+money[i]);
            
            
        }
        
        return Math.max(dp[money.length-1] , dp2[money.length-1] );
    }
}