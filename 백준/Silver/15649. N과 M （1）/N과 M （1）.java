import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] nums;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nums = new int[M];
        isUsed = new boolean[N];

        dfs(0);
    }

    static void dfs(int index){
        if(index == M){
            for(int n:nums){
                System.out.print(n+" ");
            }
            System.out.println();
            return;
        }

        for(int i=1;i<=N;i++){
            if(!isUsed[i-1]) {
                nums[index] = i;
                isUsed[i - 1] = true;
                dfs(index+1);
                isUsed[i-1] = false;
            }
         }
    }
}
