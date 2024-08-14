

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<N;j++){
                board[i][j] = input.charAt(j);
            }
        }

        int x = 0;
        for(int i=0;i<N;i++){
            int count = 0;
            for(int j=0;j<N;j++){
                if(board[i][j] == 'X'){
                    if(count >= 2) x++;
                    count = 0;
                }else{
                    count++;
                }
            }
            if(count >= 2) x++;
        }

        int y = 0;
        for(int i=0;i<N;i++){
            int count = 0;
            for(int j=0;j<N;j++){
                if(board[j][i] == 'X'){
                    if(count >= 2) y++;
                    count = 0;
                }else{
                    count++;
                }
            }
            if(count >= 2) y++;
        }

        System.out.println(x+" "+y);
    }
}
