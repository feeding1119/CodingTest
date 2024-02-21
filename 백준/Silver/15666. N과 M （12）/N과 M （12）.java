import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] nArr;
    static int[] resultArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        nArr = new int[N];
        resultArr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            nArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nArr);

        dfs(0,0);
    }

    static void dfs(int index,int prevValue){
        if(index == M){
            for(int result : resultArr){
                System.out.print(result+" ");
            }
            System.out.println();
            return;
        }

        int usedValue = 0;

        for(int i=0;i<N;i++){
            if(prevValue <= nArr[i]){
                if(usedValue != nArr[i]){
                    usedValue = nArr[i];
                    resultArr[index] = nArr[i];
                    dfs(index+1,nArr[i]);
                }
            }
        }


    }
}
