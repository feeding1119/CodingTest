import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] nSwitch;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        nSwitch = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            nSwitch[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());

            pressButton(sex,switchNum);
        }

        for(int i=1;i<=N;i++){
            if(i%20==0) {
                System.out.println(nSwitch[i]);
            }else{
                System.out.print(nSwitch[i]+" ");
            }


        }
    }

    static void pressButton(int sex, int switchNum) {
        if(sex == 1){
            for(int i=1;i<=N;i++){
                if(i%switchNum == 0) switchLight(i);
            }
        }else if(sex == 2){
            int start = switchNum;
            int end = switchNum;

            while(true){
                if(start <= 1 || end >= N){
                    break;
                }
                start--;
                end++;

                if(nSwitch[start] != nSwitch[end]){
                    start++;
                    end--;
                    break;
                }
            }

            for(int i=start;i<=end;i++){
                switchLight(i);
            }
        }
    }

    static void switchLight(int index){
        if(nSwitch[index] == 1){
            nSwitch[index] = 0;
        }else if(nSwitch[index] == 0){
            nSwitch[index] = 1;
        }
    }
}
