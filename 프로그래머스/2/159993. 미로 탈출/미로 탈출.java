import java.util.*;

class Solution {
    int[] dx = new int[] {0,0,1,-1};
    int[] dy = new int[] {1,-1,0,0};
    int[] s = new int[2];
    int[] e = new int[2];
    int[] lev = new int[2];
    char[][] maps2;
    
    public int bfs(int l, int r, int[] s2, int[] e2){
        int[][] visit = new int[l][r];
        Queue<int []> q = new LinkedList<int []>();
        q.add(new int[]{s2[0],s2[1],0});
        visit[s2[0]][s2[1]] = 1;
        while(!q.isEmpty()){
            int [] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int w = cur[2];
            if(x==e2[0] && y==e2[1]){
                return w;
            }
            
            
            
                for(int j=0; j<4; j++){
                    int nx = x+dx[j];
                    int ny = y+dy[j];
                    if(nx>=l || ny >=r || nx<0 || ny <0 ) continue;
                    
                    if(visit[nx][ny]==0 && maps2[nx][ny]!='X'){
                        visit[nx][ny] =1;
                        q.add(new int[]{nx,ny,w+1});
                    }
                }
            
            
            
        }
        return -1;
    }
    
    
    
    public int solution(String[] maps) {
        int answer = 0;
        int l = maps.length;
        int r = maps[0].length();
        maps2 = new char[l][r];
        
        for(int i =0; i<l; i ++){
            for(int j=0; j<r; j++){
                maps2[i][j]=maps[i].charAt(j);
                if(maps2[i][j] == 'S'){
                    s[0]=i;
                    s[1]=j;
                }
                if(maps2[i][j] == 'E'){
                    e[0]=i;
                    e[1]=j;
                }
                if(maps2[i][j] == 'L'){
                    lev[0]=i;
                    lev[1]=j;
                }
                
            }
        }
        int a = bfs(l,r,s,lev);
        int b = bfs(l,r,lev,e);
        
        if (a==-1) return -1;
        if (b== -1) return -1;
        
        answer =a+b;
        
        
        return answer;
        
    }
}