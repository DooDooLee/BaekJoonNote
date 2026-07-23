import java.util.*;

class Solution {
    int [][] graph;
    int answer = 0;
    int[] info;
    int[][] edges;
    public int solution(int[] a, int[][] b) {
        info = a;
        edges = b;
        int mask = 1;
        graph = new int [info.length][2];
        
        for(int i =0; i<edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            if(graph[x][0]==0){
                graph[x][0] = y;
            }else{
                graph[x][1] = y;
            }
        }
        
        
        dfs(1,0,new int[]{1,0});
        
        
        return answer;
    }
    
    public void dfs(int mask, int node, int[] swCount){
        answer = Math.max(answer, swCount[0]);
        int gap = swCount[0] - swCount[1];
        int sheep = swCount[0];
        int wolf = swCount[1];
        
        for(int i =0; i<info.length; i++){
            int next = 0;
            if(   ( (mask>>i)&1 ) ==1  ){ //방문한 것들중에서
                for(int j =0; j<2; j++){
                     if( ((mask>>graph[i][j])&1 )==  0  ){ // 연결된 노드중 방문안한 녀석들
                         next =  graph[i][j];
                         if(info[next]==0){ //양이면
                             dfs(mask|(1<<next) , next ,new int[] {sheep+1, wolf});
                         }else{//늑대면
                             if(gap-1 >0){
                                 dfs(mask|(1<<next) , next ,new int[] {sheep, wolf+1});
                             }
                         }
                     }
                }
            }
        }
    }
    
}