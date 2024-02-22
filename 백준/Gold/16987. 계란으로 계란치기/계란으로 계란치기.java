import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static int N;
    static int[] hp;
    static int[] power;

    static int answer =0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        hp = new int[N];
        power = new int[N];

        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            hp[i] = Integer.parseInt(st.nextToken());
            power[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int index){
        if(index == N) {
            int count=0;
            for(int egg : hp){
                if(egg <= 0) count++;
            }
            answer = Math.max(answer,count);
            return;
        }

        if(hp[index] > 0){
            boolean noEgg = false;
            for(int i=0;i<N;i++){
                if(hp[i] > 0 && index != i){
                    noEgg = true;
                    hp[index] -= power[i];
                    hp[i] -= power[index];

                    dfs(index+1);

                    hp[index] += power[i];
                    hp[i] += power[index];
                }
            }
            if(!noEgg) dfs(index+1);
        }else{
            dfs(index+1);
        }


    }
}
