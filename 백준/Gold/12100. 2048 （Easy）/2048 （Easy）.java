

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int answer = 0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(board,0);
        System.out.println(answer);

    }

    private static void dfs(int[][] board,int count){
        if(count == 5){
            int maxValue = findMaxValue(board);
            if(maxValue > answer) answer = maxValue;
            return;
        }
        

        dfs(moveBoard(board,1),count+1);
        dfs(moveBoard(board,2),count+1);
        dfs(moveBoard(board,3),count+1);
        dfs(moveBoard(board,4),count+1);
    }

    private static int[][] moveBoard(int[][] board,int direction){
        int[][] result = new int[N][N];
        boolean[][] isUsed = new boolean[N][N];

        if(direction == 1){
            for(int i=0;i<N;i++){
                for(int j=N-1;j>=0;j--){
                    int last = j;

                    while(true){
                        if(last+1 >= N){
                            result[i][last] = board[i][j];
                            break;
                        }

                        if(result[i][last+1] != 0){
                            if(!isUsed[i][last+1] && board[i][j] == result[i][last+1]){
                                isUsed[i][last+1] = true;
                                result[i][last+1] *= 2;
                                break;
                            }else{
                                result[i][last] = board[i][j];
                                break;
                            }
                        }
                        last++;
                    }
                }
            }
        }else if(direction == 2){
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    int last = j;

                    if(board[i][j] == 0) continue;

                    while(true){
                        if(last-1 < 0 ){
                            result[i][last] = board[i][j];
                            break;
                        }

                        if(result[i][last-1] != 0){
                            if(!isUsed[i][last-1] && board[i][j] == result[i][last-1]){
                                isUsed[i][last-1] = true;
                                result[i][last-1] *= 2;
                                break;
                            }else{
                                result[i][last] = board[i][j];
                                break;
                            }
                        }
                        last--;
                    }
                }

            }
        }else if(direction == 3){
            for(int j=0;j<N;j++){
                for(int i=N-1;i>=0;i--){
                    int last = i;

                    if(board[i][j] == 0) continue;

                    while(true){
                        if(last+1 >= N){
                            result[last][j] = board[i][j];
                            break;
                        }

                        if(result[last+1][j] != 0){
                            if(!isUsed[last+1][j] && board[i][j] == result[last+1][j]){
                                isUsed[last+1][j] = true;
                                result[last+1][j] *= 2;
                                break;
                            }else{
                                result[last][j] = board[i][j];
                                break;
                            }
                        }
                        last++;
                    }
                }
            }

        }else if(direction == 4){
            for(int j=0;j<N;j++){
                for(int i=0;i<N;i++){
                    int last = i;

                    if(board[i][j] == 0) continue;

                    while(true){
                        if(last-1 < 0){
                            result[last][j] = board[i][j];
                            break;
                        }

                        if(result[last-1][j] != 0){
                            if(!isUsed[last-1][j] && board[i][j] == result[last-1][j]){
                                isUsed[last-1][j] = true;
                                result[last-1][j] *= 2;
                                break;
                            }else{
                                result[last][j] = board[i][j];
                                break;
                            }
                        }
                        last--;
                    }
                }
            }

        }

        return result;
    }
    private static int findMaxValue(int[][] board){
        int value = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(value < board[i][j]) value = board[i][j];
            }
        }

        return value;
    }

    private static void printBoard(int[][] board){
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println();
    }
}
