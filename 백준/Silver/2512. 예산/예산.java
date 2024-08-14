import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] budget;
    static int answer = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        budget = new int[N];

        StringTokenizer  st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            budget[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        Arrays.sort(budget);
        dfs(0,budget[N-1],M);

        System.out.println(answer);
    }

    public static void dfs(int start, int end, int totalBudget){
        if(start > end) return;

        int mid = (start+end)/2;

        int usedBudget = checkBudget(mid);

        if(usedBudget > totalBudget){
            dfs(start,mid-1,totalBudget);
        }else{
            answer = mid;
            dfs(mid+1,end,totalBudget);
        }



    }

    public static int checkBudget(int n){
        int result = 0;
        for(int i=0;i<budget.length;i++){
            if(budget[i] < n) result += budget[i];
            else result += n;
        }

        return result;
    }
}
