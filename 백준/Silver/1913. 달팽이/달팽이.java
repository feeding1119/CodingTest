import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = sc.nextInt();

        int target = sc.nextInt();

        int[][] snail = new int[N][N];

        int mid = N/2;
        int start = N*N;
        int count = N-1;

        snail[mid][mid] = 1;

        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};

        for(int k=0;k<mid;k++){
            int nx = k;
            int ny = k;

            for(int i=0;i<4;i++){
                for(int j=0;j<count;j++){
                    snail[nx][ny] = start--;
                    nx = nx + dx[i];
                    ny = ny + dy[i];
                }
            }
            count-=2;
        }

        int targetx=0;
        int targety=0;

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                bw.write(snail[i][j]+" ");
                if(snail[i][j] == target){
                    targetx = i+1;
                    targety = j+1;
                }
            }
            bw.write("\n");
        }

        bw.write(targetx+" "+targety);
        bw.close();

    }
}
