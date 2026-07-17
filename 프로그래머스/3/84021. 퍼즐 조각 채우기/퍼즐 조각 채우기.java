import java.util.*;
import java.io.*;


class Solution {
    int [][] tVisit = new int [50][50];
    int [][] gVisit = new int[50][50];
    int [] dx = new int[] {0,1,0,-1};
    int [] dy = new int[]{1,0,-1,0};
    int minX;
    int minY;
    ArrayList <ArrayList<int []>> puzzle;
    ArrayList<int[]> empty;
    
    public int solution(int[][] game_board, int[][] table) {
        
        int answer = 0;
        int indexP = 0;
        int pCount = 0;
        puzzle = new ArrayList <>();
        
        for(int i =0; i<table.length; i++){
            for(int j =0; j<table.length; j++){
                if(tVisit[i][j]==0 && table[i][j]==1){
                    minX = 999;
                    minY = 999;
                    dfs(i,j,indexP,table);
                    
                    for(int[] temp : puzzle.get(indexP)){
                        temp[0] -= minX;
                        temp[1] -= minY;
                    }
                    indexP++; 
                }
            }
        }
        
        
        int [] used = new int [puzzle.size()];
        
        
        
        
        for(int i =0; i<game_board.length; i++){
            for(int j =0; j<game_board.length; j++){
                if(gVisit[i][j]==0 && game_board[i][j]==0){
                    empty = new ArrayList<>();
                    minX = 999;
                    minY = 999;
                    dfs2(i,j,game_board);
                    for(int[] temp : empty){
                        temp[0] -= minX;
                        temp[1] -= minY;
                    }
                    boolean isFull= false;
                    for(int k =0; k<puzzle.size(); k++){
                        if(used[k] == 1) continue;
                        if(isFull) break;
                        if(puzzle.get(k).size() != empty.size()) continue;
                        
                        
                        
                        for(int r = 0; r<4; r++){
                            boolean isM = true;
                            minX = 999;
                            minY = 999;
                            for(int temp[] : puzzle.get(k)){
                                int tempY = temp[1];
                                int tempX = temp[0];
                                temp[0] = tempY;
                                temp[1] = (table.length - 1) -tempX;
                                
                                minX = Math.min(temp[0],minX);
                                minY = Math.min(temp[1],minY);
                            }
                            
                            for(int temp[] : puzzle.get(k)){
                                temp[0] = temp[0] - minX;
                                temp[1] = temp[1] - minY;
                            }
                            
                            
                            empty.sort((a,b)->a[0]==b[0]? a[1]-b[1] : a[0]-b[0] );
                            puzzle.get(k).sort((a,b)->a[0]==b[0]? a[1]-b[1] : a[0]-b[0]);
                            
                            for(int tempIndex = 0; tempIndex<empty.size(); tempIndex++){
                                if(puzzle.get(k).get(tempIndex)[0] != empty.get(tempIndex)[0] || puzzle.get(k).get(tempIndex)[1] != empty.get(tempIndex)[1]){
                                    isM = false;
                                    continue;
                                }
                            }
                            
                            if(isM){
                                answer += empty.size();
                                used[k] =1;
                                isFull=true;
                                break;
                            }
                            
                            
                        }
                        
                        
                    }
                    
                }
                  
            }
        }
        
        
        return answer;
    }
    
    public void dfs2(int x, int y, int[][] game_board){
        if(gVisit[x][y] == 0 && game_board[x][y] == 0){
            gVisit [x][y] = 1;
        
            minX = Math.min(x,minX);
            minY = Math.min(y,minY);
            empty.add(new int[]{x,y});
             for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<game_board.length && ny<game_board.length && ny>=0){
                    dfs2(x+dx[i] , y+dy[i],game_board);
                }
                
            }
            
        }else{
            gVisit [x][y] = 1;
            return;
        }
    }
    
    
    public void dfs(int x, int y, int idx, int[][] table){
        if(tVisit[x][y] == 0 && table[x][y] == 1){
            tVisit [x][y] = 1;
            if(puzzle.size()<=idx){ //puzzle.get(idx)==null 로 조건을 세웟는데 그러면 null이 아니라 인덱스 초과에러
                puzzle.add(new ArrayList<int []>());
            }
            minX = Math.min(x,minX);
            minY = Math.min(y,minY);
            puzzle.get(idx).add(new int[]{x,y});
            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx>=0 && nx<table.length && ny<table.length && ny>=0){
                    dfs(x+dx[i] , y+dy[i], idx ,table);
                }
                
            }
        }else{
            tVisit [x][y] = 1;
            return;
        }
    }
}