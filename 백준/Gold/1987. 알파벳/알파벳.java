

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static int answer = 0;
    static char[][] board;
    static int r,c;
    static boolean[][] v;
    static HashSet<Character> s = new HashSet<>();

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        board = new char[r][c];
        v = new boolean[r][c];

        for(int i=0;i<r;i++){
            String input = br.readLine();

            for(int j=0;j<c;j++){
                board[i][j] = input.charAt(j);
            }
        }

        v[0][0] = true;
        s.add(board[0][0]);

        dfs(0,0,1);

        System.out.println(answer);
    }

    public static void dfs(int x,int y,int d){
        answer = Math.max(answer,d);

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny>=0 && nx<r && ny<c && !v[nx][ny] && !s.contains(board[nx][ny])){
                s.add(board[nx][ny]);
                v[nx][ny] = true;
                dfs(nx,ny,d+1);
                v[nx][ny] = false;
                s.remove(board[nx][ny]);
            }
        }
    }
}
