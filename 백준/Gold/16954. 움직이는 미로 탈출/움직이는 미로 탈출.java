
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[] dx = {0,-1,-1,0,1,1,1,0,-1};
    static int[] dy = {0,0,1,1,1,0,-1,-1,-1};
    static boolean[][] map;
    static boolean[][] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new boolean[8][8];

        for(int i=0;i<8;i++){
            String input = br.readLine();
            for(int j=0;j<8;j++){
                if(input.charAt(j) == '.') map[i][j] = false;
                else map[i][j] = true;
            }
        }

        bfs();


    }

    private static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{7,0});

        while(!q.isEmpty()){


            v = new boolean[8][8];

            int qs = q.size();
            for(int k=0;k<qs;k++){
                int[] temp = q.poll();
                if(map[temp[0]][temp[1]]) continue;

                if(temp[0] == 0 && temp[1] == 7) {
                    System.out.println(1);
                    return;
                }

                for(int i=0;i<9;i++){
                    int nx = temp[0] + dx[i];
                    int ny = temp[1] + dy[i];

                    if(nx>=0 && ny >=0 && nx<8 && ny<8 && !map[nx][ny] && !v[nx][ny]){
                        v[nx][ny] = true;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }


            moveWall();
        }

        System.out.println(0);
    }

    private static void moveWall(){
        for(int i=7;i>=0;i--){
            for(int j=0;j<8;j++){
                if(map[i][j]){
                    map[i][j] = false;
                    if(i != 7) map[i+1][j] = true;
                }
            }
        }
    }

    private static void printMap(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(map[i][j]){
                    System.out.print("# ");
                }else{
                    System.out.print(". ");
                }
            }
            System.out.println();
        }

        System.out.println();
    }
}
