import java.util.*;

class Solution { 
    int [][] map = new int[101][101];  
    int [][] visit = new int[101][101];
    int [] dx = new int[] {0,0,-1,1};
    int [] dy = new  int[] {1,-1,0,0};
    
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        int sx = characterX*2;
        int sy = characterY*2;
        for(int i =0; i<rectangle.length; i++) {
            for(int j=0; j<4; j++){
                rectangle[i][j] += rectangle[i][j];
            }
        }
        
        Queue<int []> q = new LinkedList<>();
        
        q.add(new int[] {sx,sy,0});
        
        
        while(!q.isEmpty()){
            int [] temp = q.poll();
            int cx = temp[0];
            int cy = temp[1];
            int dist = temp[2];
            
            visit[cx][cy] =1;
            if(cx==itemX*2 && cy==itemY*2){
                answer = dist;
                break;
            }
            
            for(int i =0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                boolean isIn =false;
                boolean isL = false;
                
                if(nx>0 && nx<=100 && ny>0 && ny<=100 && visit[nx][ny] ==0){
                    for(int j =0; j<rectangle.length; j++){
                       
                        isIn = isIn(rectangle[j], nx, ny);
                        if(isL==false){
                            isL = isLine(rectangle[j], nx, ny);
                        }
                        
                            
                           
                        if(isIn){
                            break;
                        }
                    }
                    if(isIn==false && isL==true){
                        q.add(new int [] {nx,ny,dist+1});
                    }
                    
                    
                }
            
            
            
            }
            
        }
        
        
        
        
        return answer/2;
    }
    public boolean isIn(int[] rec, int x, int y){ //false여야 좋음
        int x1 = rec[0];
        int y1 = rec[1];
        int x2 = rec[2];
        int y2 = rec[3];
        
        if(x<x2 && x>x1 && y<y2 && y>y1){
            return true;
        }
        return false;
        
    
    
    }
        
    
    
    
    public boolean isLine(int[] rec, int x, int y){ //하나가  true
        int x1 = rec[0];
        int y1 = rec[1];
        int x2 = rec[2];
        int y2 = rec[3];
        
        if(x==x1){
            if(y>=y1 && y<=y2){
                return true;
            }
        }else if(x==x2){
            if(y>=y1 && y<=y2){
                return true;
            }
        }else if(y==y1){
            if(x>=x1 && x<=x2){
                return true;
            }
        }else if(y==y2){
            if(x>=x1 && x<=x2){
                return true;
            }
        }
        return false;
    }
    
}