

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m,h;
    static int[][] ladder;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        ladder = new int[h][n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;

            ladder[a][b] = 1;
        }

        selectLadder(0,0,0);
        selectLadder(0,1,0);
        selectLadder(0,2,0);
        selectLadder(0,3,0);

        System.out.println(-1);

    }

    public static void selectLadder(int c,int count,int x){
        if(c == count){
            if(startLadder()){
                System.out.println(c);
                System.exit(0);
            }

            return;
        }

        for(int i=x;i<h;i++){
            for(int j=0;j<n-1;j++){
                if(ladder[i][j] != 1 && (j==0 || ladder[i][j-1] != 1) && ladder[i][j+1] != 1){
                    ladder[i][j] = 1;
                    selectLadder(c+1,count,i);
                    ladder[i][j] = 0;
                }
            }
        }

    }


    public static boolean startLadder(){

        for(int i=0;i<n;i++){

            int now = i;

            for(int j=0;j<h;j++){
                if(ladder[j][now] == 1) now++;
                else if(now-1>=0 && ladder[j][now-1] == 1) now--;

            }

            if(i != now) return false;
        }

        return true;
    }
}
