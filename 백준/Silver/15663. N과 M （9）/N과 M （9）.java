import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] nArr;
    static boolean[] isUsed;
    static int[] resultArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nArr = new int[N];
        isUsed = new boolean[N];
        resultArr = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);

        dfs(0);
    }

    static void dfs(int index){
        if(index == M){
            for(int result: resultArr){
                System.out.print(result+" ");
            }
            System.out.println();
            return;
        }

        int prevValue = 0;

        for(int i=0;i<N;i++){
            if(!isUsed[i] && prevValue!=nArr[i]){
                prevValue = nArr[i];
                resultArr[index] = nArr[i];
                isUsed[i] = true;
                dfs(index+1);
                isUsed[i] = false;
            }
        }

    }
}
