import java.util.*;

class Solution {
    
    static boolean[] v;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        
        boolean[][] conn = new boolean[n+1][n+1];
        
        for(int i=0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            conn[a][b] = true;
            conn[b][a] = true;
        }
        
        for(int i=0;i<wires.length;i++){
            int a = wires[i][0];
            int b = wires[i][1];
            
            conn[a][b] = false;
            conn[b][a] = false;
            
            v = new boolean[n+1];
            
            int calc = 0;
            for(int j=1;j<=n;j++){
                if(!v[j]){
                    if(calc == 0) calc = checkWires(conn,j);
                    else{
                        calc = Math.abs(calc - checkWires(conn,j));
                        break;
                    }
                }
            }
            
            if(calc < answer) answer = calc;
            conn[a][b] = true;
            conn[b][a] = true;
        }
        return answer;
    }
    
    private int checkWires(boolean[][] conn,int x){
        int count = 0;
        
        v[x] = true;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        while(!q.isEmpty()){
            int temp = q.poll();
            
            for(int i=1;i<conn[temp].length;i++){
                if(conn[temp][i] && !v[i]){
                    v[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }
        
        return count;
        
    }
}