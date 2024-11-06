
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int[][] board = new int[n][n];

        board[0][0] = 1;

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());

            int appleX = Integer.parseInt(st.nextToken());
            int appleY = Integer.parseInt(st.nextToken());

            board[appleX-1][appleY-1] = 2;
        }

        int l = Integer.parseInt(br.readLine());

        int[][] move = new int[l][2];
        for(int i=0;i<l;i++){
            st = new StringTokenizer(br.readLine());

            move[i][0] = Integer.parseInt(st.nextToken());

            String way = st.nextToken();

            if(way.equals("L")) move[i][1] = 1;
            if(way.equals("D")) move[i][1] = 2;
        }

        int direction = 1;
        int time = 1;
        int moveIndex = 0;
        int snakeX = 0;
        int snakeY = 0;

        Deque<int[]> snake = new ArrayDeque<>();
        snake.offer(new int[]{snakeX,snakeY});

        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        snakeX += dx[direction-1];
        snakeY += dy[direction-1];

        while(true){
            // printBoard(board,n);
            if(snakeX < 0 || snakeY < 0 || snakeX >= n || snakeY >= n) break;
            if(board[snakeX][snakeY] == 1) break;

            if(moveIndex < l){
                if(move[moveIndex][0] == time){
                    direction = changeDirection(direction,move[moveIndex][1]);
                    moveIndex++;
                }
            }

            if(board[snakeX][snakeY] == 0) {
                int[] tail = snake.pollFirst();
                board[tail[0]][tail[1]] = 0;
            }

            board[snakeX][snakeY] = 1;
            snake.offer(new int[]{snakeX,snakeY});

            snakeX += dx[direction-1];
            snakeY += dy[direction-1];

            time++;
        }

        System.out.println(time);
    }

    static private void printBoard(int[][] board,int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
    }

    static private int changeDirection(int curDir,int way){
        // dir - 1:우 2:좌 3:상 4:하 /way - 1:L 2:D
        if(curDir == 1){
            if(way == 1) return 3;
            if(way == 2) return 4;
        }

        if(curDir == 2){
            if(way == 1) return 4;
            if(way == 2) return 3;
        }

        if(curDir == 3){
            if(way == 1) return 2;
            if(way == 2) return 1;
        }

        if(curDir == 4){
            if(way == 1) return 1;
            if(way == 2) return 2;
        }

        return -1;
    }
}
