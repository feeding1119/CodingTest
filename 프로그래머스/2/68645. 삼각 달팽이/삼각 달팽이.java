import java.util.*;

class Solution {
    static int[][] snail;
    static int num = 1;
    static int x = -1;
    static int y = 0;
    public int[] solution(int n) {
        snail = new int[n][n];
        
        int turn = 0;
        int count = n;
        for(int i=0;i<n;i++){
            if(turn%3 == 0){
                moveDown(count);
            }else if(turn%3 == 1){
                moveRight(count);
            }else if(turn%3 == 2){
                moveLeftUp(count);
            }
            
            turn++;
            count--;
        }
        
        
        
        int[] answer =new int[num-1];
        
        int index =0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(snail[i][j] != 0) answer[index++] = snail[i][j];
            }
        }
        return answer;
    }
    
    public void moveDown(int count){
        for(int i=0;i<count;i++){
            snail[++x][y] = num++;
        }
    }
    
    public void moveRight(int count){
        for(int i=0;i<count;i++){
            snail[x][++y] = num++;
        }
    }
    
    public void moveLeftUp(int count){
        for(int i=0;i<count;i++){
            snail[--x][--y] = num++;
        }
    }
}