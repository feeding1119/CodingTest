import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;

    static int[] numArr;
    static int[] signArr;
    static boolean[] signUsed;

    static int maxResult = Integer.MIN_VALUE;
    static int minResult = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        signArr = new int[N-1];
        signUsed = new boolean[N-1];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N;i++){
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int tempIndex = 0;
        for(int i=0;i<4;i++){
            int temp = Integer.parseInt(st.nextToken());
            for(int j=0;j<temp;j++){
                signArr[tempIndex++] = i;
            }
        }

        dfs(1,numArr[0]);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    static void dfs(int index,int cost){
        if(index==N){
            maxResult = Math.max(maxResult,cost);
            minResult = Math.min(minResult,cost);
            return;
        }

        for(int i=0;i<N-1;i++){
            if(!signUsed[i]){
                signUsed[i] = true;
                if(signArr[i] == 0){
                    dfs(index+1,cost+numArr[index]);
                }else if(signArr[i] == 1){
                    dfs(index+1,cost-numArr[index]);
                }else if(signArr[i] == 2){
                    dfs(index+1,cost*numArr[index]);
                }else if(signArr[i] == 3){
                    dfs(index+1,cost/numArr[index]);
                }
                signUsed[i] = false;
            }

        }


    }


}
