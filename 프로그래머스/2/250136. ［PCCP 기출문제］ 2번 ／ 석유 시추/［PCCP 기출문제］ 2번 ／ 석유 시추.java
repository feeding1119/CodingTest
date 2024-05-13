import java.util.*;
class Solution {
    static int n,m;
    static int[][] land;
    static boolean[][] v;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int count = 0;
    
    static Map<Integer,Integer> map;
    static int[] answer;
     
    public int solution(int[][] land) {
        
        this.land = land;
        
        n = land.length;
        m = land[0].length;
        
        v = new boolean[n][m];
        
        answer = new int[m];
        map = new HashMap<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!v[i][j] && land[i][j] == 1){
                    count = 0;
                    dfs(i,j);
                    
                    for(int key : map.keySet()){
                        answer[key] += count;
                    }
                    
                    map = new HashMap<>();
                }
            }
        }
        
        int result = 0;
        
        for(int i=0;i<m;i++){
            if(answer[i] > result) result =answer[i];
        }
        
        return result;
    }
    
    public void dfs(int x,int y){
        v[x][y] = true;
        count++;
        map.put(y,1);
        
        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];
            
            if(nx>=0 && ny>=0 && nx<n && ny<m){
                if(!v[nx][ny] && land[nx][ny] == 1) dfs(nx,ny);
                
            }
        }
    }
    
}