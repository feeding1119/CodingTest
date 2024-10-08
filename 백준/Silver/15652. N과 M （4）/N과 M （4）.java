
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[M];

        dfs(0,1);
    }

    private static void dfs(int index,int value){
        if(index == M){
            for(int i=0;i<M;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();

            return;
        }

        for(int i=value;i<=N;i++){
            ans[index] = i;
            dfs(index+1, i);
        }
    }
}
