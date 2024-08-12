import java.util.*;


class Solution {
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        
        
        for(int i=0;i<5;i++){
            if(bfs(places[i])) answer[i] = 1;
        }
        return answer;
    }
    
    public boolean bfs(String[] place){
        
        Character[][] map = makeMap(place);
        
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(map[i][j] == 'P') {
                    q.offer(new int[]{i,j,0});
                    boolean[][] isVisited = new boolean[5][5];
                    isVisited[i][j] = true;
                    while(!q.isEmpty()){
                        int[] temp = q.poll();
                        
                        for(int k=0;k<4;k++){
                            int nx = temp[0]+dx[k];
                            int ny = temp[1]+dy[k];

                            if(nx>=0&&ny>=0&&nx<5&&ny<5&&temp[2]<2&&!isVisited[nx][ny]){
                                isVisited[nx][ny]= true;
                                if(map[nx][ny] == 'X') continue;

                                if(map[nx][ny] == 'P') return false;

                                q.offer(new int[]{nx,ny,temp[2]+1});
                            }
                        }
                    }
                }
            }
        }
        
        
        return true;
    }
    
    
    public Character[][] makeMap(String[] place){
        Character[][] map = new Character[5][5];
        
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                map[i][j] = place[i].charAt(j);
            }
        }
        
        return map;
    }
}