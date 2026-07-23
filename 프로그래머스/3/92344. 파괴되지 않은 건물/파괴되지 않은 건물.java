class Solution {
    public int solution(int[][] board, int[][] skill) {
        
        int answer = 0;
        int [][] board2 = new int [board.length+1][board[1].length+1];
        
        for(int i=0; i<skill.length; i++){
            int type = skill[i][0];
            int r1 = skill[i][1];
            int c1 = skill[i][2];
            int r2 = skill[i][3];
            int c2 = skill[i][4];
            int degree =skill[i][5];
            degree = type==1? degree*(-1) : degree;
            
            board2[r1][c1] +=degree;
            board2[r1][c2+1] -= degree;
            board2[r2+1][c1] -= degree;
            board2[r2+1][c2+1] += degree;
        } 
        
        for(int i =0; i<board2.length; i++){
            for(int j=1; j<board2[1].length; j++){
                board2[i][j] += board2[i][j-1];
            }
        }
        for(int i =0; i<board2[1].length; i++){
            for(int j=1; j<board2.length; j++){
                board2[j][i] += board2[j-1][i];
            }
        }
        
        for(int i= 0; i<board.length; i++){
            for(int j=0; j<board[1].length; j++){
                if(board[i][j]+board2[i][j]>0){
                    answer++;
                }
            }
        }
        
        
        return answer;
    }
}