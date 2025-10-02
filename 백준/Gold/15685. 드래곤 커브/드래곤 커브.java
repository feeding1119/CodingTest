

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static boolean[][] board = new boolean[101][101];

    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,-1,0,1};

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());

            dragonCurve(x,y,d,g);
        }

        countAnswer();

        System.out.println(answer);
    }

    public static void countAnswer(){
        for(int i=0; i<100; i++) {
            for(int j=0; j<100; j++) {
                if(board[i][j] && board[i+1][j] && board[i][j+1] && board[i+1][j+1]) answer++;
            }
        }
    }

    public static void dragonCurve(int x,int y,int d,int g){
        List<Integer> dList = new ArrayList<>();
        dList.add(d);
        board[y][x] = true;

        for(int i=1; i<=g; i++) {
            for(int j=dList.size()-1; j>=0; j--) {
                dList.add((dList.get(j) + 1) % 4);
            }
        }
        for(Integer dir : dList) {
            x += dx[dir];
            y += dy[dir];
            board[y][x] = true;
        }
    }
}
