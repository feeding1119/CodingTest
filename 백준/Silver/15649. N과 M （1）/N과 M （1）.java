import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static boolean[] isUsed;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isUsed = new boolean[N+1];
        nums = new int[M+1];

        recursion(0);
    }

    static void recursion(int idx){
        if(idx == M){

            for(int i=0;i<M;i++){
                System.out.print(nums[i]+1 + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0;i<N;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                nums[idx] = i;
                recursion(idx+1);
                isUsed[i] = false;
            }
        }
    }
}
