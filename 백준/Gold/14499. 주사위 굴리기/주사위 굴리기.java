
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] dice = new int[6];
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        int[] diceIdx = new int[6];
        for(int i=0;i<6;i++){
            diceIdx[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<k;i++){
            int command = Integer.parseInt(st.nextToken());

            x += dx[command-1];
            y += dy[command-1];

            if(x<0 || y<0 || x>= n || y>= m){
                x -= dx[command-1];
                y -= dy[command-1];

                continue;
            }

            moveDice(diceIdx,command);


            if(map[x][y] == 0){
                map[x][y] = dice[diceIdx[5]];
            }else{
                dice[diceIdx[5]] = map[x][y];
                map[x][y] = 0;
            }

            System.out.println(dice[diceIdx[0]]);
        }


    }

    static private void printDice(int[] dice){
        System.out.println("  "+dice[1]+"  ");
        System.out.println(dice[3]+" "+dice[0]+" "+dice[2]);
        System.out.println("  "+dice[4]+"  ");
        System.out.println("  "+dice[5]+"  ");
        System.out.println("================");
    }

    static private void moveDice(int[] dice,int way){
        if(way == 1){
            int temp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[5];
            dice[5] = dice[2];
            dice[2] = temp;
            return;
        }

        if(way == 2){
            int temp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[3];
            dice[3] = temp;
            return;
        }

        if(way == 3){
            int temp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[5];
            dice[5] = dice[1];
            dice[1] = temp;
            return;
        }

        if(way == 4){
            int temp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[5];
            dice[5] = dice[4];
            dice[4] = temp;
            return;
        }
    }
}
