
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N,M,X;
    static List<Integer>[] tasks;
    static boolean[] visitied;

    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tasks = new ArrayList[N+1];
        visitied = new boolean[N+1];

        for(int i=0;i<=N;i++){
            tasks[i] = new ArrayList<>();
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            tasks[b].add(a);
        }

        X = Integer.parseInt(br.readLine());
        dfs(X);

        System.out.println(count);
    }

    private static void dfs(int n){
        visitied[n] = true;

        for(int task : tasks[n]){
            if(!visitied[task]){
                count++;
                dfs(task);
            }
        }
    }
}
