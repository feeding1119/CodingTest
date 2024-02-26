import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] bingo = new int[5][5];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                checkBingo(Integer.parseInt(st.nextToken()));
                int count = countBingo();
                if(count >= 3){
                    System.out.println(i*5+j+1);
                    System.exit(0);
                }
            }
        }
    }
    static int countBingo(){
        int count = 0;

        //가로 빙고 체크
        for(int i=0;i<5;i++){
            boolean isBingo = true;

            for(int j=0;j<5;j++){
                if(bingo[i][j]!= 0) isBingo=false;
            }

            if(isBingo) count++;
        }

        //세로 빙고 체크
        for(int i=0;i<5;i++){
            boolean isBingo = true;

            for(int j=0;j<5;j++){
                if(bingo[j][i]!= 0) isBingo=false;
            }

            if(isBingo) count++;
        }

        //대각 빙고 체크
        boolean isBingo = true;
        for(int i=0;i<5;i++){
            if(bingo[i][i]!= 0) isBingo=false;
        }
        if(isBingo) count++;

        isBingo = true;
        for(int i=0;i<5;i++){
            if(bingo[i][4-i]!= 0) isBingo=false;
        }
        if(isBingo) count++;

        return count;
    }

    static void checkBingo(int value){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                if(bingo[i][j] == value){
                    bingo[i][j] = 0;
                    return;
                }
            }
        }
    }
}
