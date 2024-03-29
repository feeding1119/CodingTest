import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,S;
    static int[] nArr;

    static int answer =0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        nArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);

        dfs(0,0);

        if(S==0){
            System.out.println(answer-1);
        }else{
            System.out.println(answer);
        }
    }

    static void dfs(int index, int sum){
        if(index == N){
            if(sum == S) answer++;
            return;
        }


        dfs(index+1,sum+nArr[index]);
        dfs(index+1,sum);
    }
}
