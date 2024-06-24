class Solution {
    
    static int zeroCount,oneCount = 0;
    public int[] solution(int[][] arr) {
        
        int arrSize = arr.length;
        dfs(arr,0,0,arrSize);
        
        int[] answer = {zeroCount,oneCount};
        return answer;
    }
    
    public void dfs(int[][] board,int x,int y,int size){
        if(size == 1){
            if(board[x][y] == 0) zeroCount++;
            if(board[x][y] == 1) oneCount++;
            return;
        }
        
        if(checkSquare(board,x,y,size)){
            if(board[x][y] == 0) zeroCount++;
            if(board[x][y] == 1) oneCount++;
            
            return;
        }
        
        int reSize = size/2;
        dfs(board,x,y,reSize);
        dfs(board,x+reSize,y,reSize);
        dfs(board,x,y+reSize,reSize);
        dfs(board,x+reSize,y+reSize,reSize);
    }
    
    public boolean checkSquare(int[][] board,int x,int y,int size){
        int num = board[x][y];
        
        for(int i=x;i<x+size;i++){
            for(int j=y;j<y+size;j++){
                if(num != board[i][j]) return false;
            }
        }
        
        return true;
    }
    
}