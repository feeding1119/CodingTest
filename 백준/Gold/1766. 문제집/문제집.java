
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            indegree[b]++;
            graph.get(a).add(b);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=1;i<=n;i++){
            if(indegree[i] == 0) pq.offer(i);
        }

        ArrayList<Integer> answer = new ArrayList<>();

        while(!pq.isEmpty()){
            int now = pq.poll();
            answer.add(now);

            for(int next : graph.get(now)){
                indegree[next]--;
                if(indegree[next] == 0) pq.offer(next);
            }
        }


        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i)+" ");
        }
    }
}
