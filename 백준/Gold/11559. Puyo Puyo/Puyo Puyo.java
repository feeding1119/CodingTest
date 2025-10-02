import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int n = 12;
    static int m = 6;
    static char[][] map;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[n][m];

        for(int i=0;i<12;i++){
            String input = br.readLine();
            for(int j=0;j<6;j++){
                map[i][j] = input.charAt(j);
            }
        }

        playPuyo();

        System.out.println(answer);

    }

    public static void printMap(){

        System.out.println("============");
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("============");
    }

    public static void playPuyo(){



        while(true){
            boolean isFinished = true;
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(map[i][j] != '.'){
                        if(checkArea(i,j)) isFinished = false;
                    }
                }
            }

            if(isFinished) break;

            answer++;
            fallArea();


        }


    }

    public static void fallArea(){

        for(int i=0;i<m;i++){
            for(int j=n-1;j>=0;j--){
                if(map[j][i] == '.'){
                    for(int k=j-1;k>=0;k--){
                        if(map[k][i] != '.'){
                           map[j][i] = map[k][i];
                           map[k][i] = '.';
                           break;
                        }
                    }
                }
            }
        }

    }

    public static boolean checkArea(int x,int y){

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        boolean[][] v = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});

        ArrayList<int[]> ls = new ArrayList<>();
        ls.add(new int[]{x,y});
        v[x][y] = true;
        char color = map[x][y];

        while(!q.isEmpty()){
            int[] now = q.poll();

            for(int i=0;i<4;i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if(nx>=0 && ny>=0 && nx<n && ny<m && !v[nx][ny] && map[nx][ny] == color){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                    ls.add(new int[]{nx,ny});
                }
            }
        }

        if(ls.size() >= 4){
            for(int[] xy : ls){
                map[xy[0]][xy[1]] = '.';
            }

            return true;
        }

        return false;
    }
}
