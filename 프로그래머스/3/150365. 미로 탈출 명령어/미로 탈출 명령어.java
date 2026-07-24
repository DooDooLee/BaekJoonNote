import java.util.*;

class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        StringBuilder  sb = new StringBuilder();
        int[] dx = new int[] {1,0,0,-1};
        int[] dy = new int[] {0,-1,1,0};
        int cx =x;
        int cy =y;
        
        if((k%2)==(dist(x,y,r,c)%2) && k>=dist(x,y,r,c)){
           while(k>0){
               for(int i =0; i<4; i++){
                   
                   String alpha = "";
                   if(i==0){
                       alpha = "d";
                   }else if(i==1){
                       alpha = "l";
                   }else if(i==2){
                       alpha = "r";
                   }else{
                       alpha = "u";
                   }
                       
                   int nx = cx+dx[i];
                   int ny = cy+dy[i];
                   
                   if(nx>0 && nx<=n && ny>0 && ny<=m && dist(nx,ny,r,c)<=(k-1) ){
                       if(nx==r && ny ==c){
                           if((k-1)==0){
                               sb.append(alpha);
                               k--;
                               cx = nx;
                               cy = ny;
                               
                            }else{
                            sb.append(alpha);
                            cx = nx;
                            cy = ny;
                            k--;
                            break;
                           }
                       }else{
                            sb.append(alpha);
                            cx = nx;
                            cy = ny;
                            k--;
                            break;
                       }
                       
                   }
               }
           }   
              
               
           
            
        return sb.toString();
            
        }else{
            return "impossible";
        }
        
    }
    
    
    
    public int dist(int x1, int y1, int x2, int y2){
        return Math.abs(x2-x1)+Math.abs(y2-y1);
    }
           
}