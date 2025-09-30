
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] indegree = new int[n+1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int pd = Integer.parseInt(st.nextToken());
            int prevS = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int nowS = Integer.parseInt(st.nextToken());

                indegree[nowS]++;
                graph.get(prevS).add(nowS);
                prevS = nowS;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();
        boolean[] v = new boolean[n+1];

        for(int i=1;i<=n;i++){
            if(indegree[i] == 0) {
                v[i] = true;
                q.offer(i);
            }
        }

        while(!q.isEmpty()){
            int now = q.poll();
            answer.add(now);

            for(int next : graph.get(now)){
                indegree[next]--;
                if(indegree[next] == 0 && !v[next]){
                    v[next] = true;
                    q.offer(next);
                }
            }

        }

        boolean flag = true;

        for(int i=1;i<=n;i++){
            if(!v[i]) flag = false;
        }

        if(flag){
            for(int i=0;i<answer.size();i++){
                System.out.println(answer.get(i));
            }
        }else{
            System.out.println(0);
        }

    }
}
