

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] wheel =  new char[4][8];
        int[] idx = new int[4];


        StringTokenizer st;

        for(int i=0;i<4;i++){
            String input = br.readLine();
            for(int j=0;j<8;j++){
                wheel[i][j] = input.charAt(j);
            }
        }

        int k = Integer.parseInt(br.readLine());

        int[] turn = {-1,1,-1,1};

        for(int i=0;i<k;i++){
            st = new StringTokenizer(br.readLine());

            int wheelNum = Integer.parseInt(st.nextToken())-1;
            int wheelDir = Integer.parseInt(st.nextToken());

            boolean[] canTurn = new boolean[4];

            canTurn[wheelNum] = true;

            for(int j=wheelNum-1;j>=0;j--){
                if(wheel[j][(idx[j]+2)%8] != wheel[j+1][(idx[j+1]+6)%8]) canTurn[j] = true;
                else break;
            }

            for(int j=wheelNum+1;j<4;j++){
                if(wheel[j][(idx[j]+6)%8] != wheel[j-1][(idx[j-1]+2)%8]) canTurn[j] = true;
                else break;
            }

            boolean dir = true;

            if((wheelNum % 2 == 1 && wheelDir == 1) || wheelNum % 2 == 0 && wheelDir == -1) dir = false;

            for(int j=0;j<4;j++){
                if(!canTurn[j]) continue;

                if(dir){
                    int temp = idx[j] + turn[j];
                    if(temp == -1) temp = 7;
                    if(temp == 8) temp = 0;
                    idx[j] = temp;
                }else{
                    int temp = idx[j] - turn[j];
                    if(temp == -1) temp = 7;
                    if(temp == 8) temp = 0;
                    idx[j] = temp;
                }
            }
        }

        int answer = 0;

        if(wheel[0][idx[0]] == '1') answer += 1;
        if(wheel[1][idx[1]] == '1') answer += 2;
        if(wheel[2][idx[2]] == '1') answer += 4;
        if(wheel[3][idx[3]] == '1') answer += 8;


        System.out.println(answer);
    }
}
