

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static String[][] map;
    static ArrayList<int[]> tList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new String[n][n];
        tList = new ArrayList<>();

        StringTokenizer st;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                String temp = st.nextToken();
                map[i][j] = temp;

                if(temp.equals("T")) tList.add(new int[]{i,j});
            }
        }

        dfs(0,0);

        System.out.println("NO");

    }

    public static void dfs(int idx,int count){
        if(count == 3){
            if(checkMap()) {
                System.out.println("YES");
                System.exit(0);
            }

            return;
        }

        for(int i=idx;i<n*n;i++){
            int x = i/n;
            int y = i%n;

            if(map[x][y].equals("X")){
                map[x][y] = "O";
                dfs(idx+1,count+1);
                map[x][y] = "X";
            }
        }


    }

    public static void printMap(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static boolean checkMap(){

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int[] xy : tList){
            int x = xy[0];
            int y = xy[1];

            for(int i=0;i<4;i++){
                int nx = x+dx[i];
                int ny = y+dy[i];

                while(nx>=0 && ny>=0 && nx<n && ny<n){
                    if(map[nx][ny].equals("O")) break;

                    if(map[nx][ny].equals("S")) return false;

                    nx += dx[i];
                    ny += dy[i];
                }
            }
        }

        return true;
    }
}
