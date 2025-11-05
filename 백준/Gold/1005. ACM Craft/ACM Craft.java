

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int tc =0;tc<t;tc++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] time = new int[n+1];
            int[] indegree = new int[n+1];
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

            for(int i=0;i<n+1;i++){
                graph.add(new ArrayList<>());
            }

            st = new StringTokenizer(br.readLine());

            for(int i=1;i<n+1;i++){
                time[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<k;i++){
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                indegree[y]++;
                graph.get(x).add(y);
            }

            int w = Integer.parseInt(br.readLine());

            int[] answer = new int[n+1];

            Queue<Integer> q = new LinkedList<>();

            for(int i=1;i<n+1;i++){

                if(indegree[i] == 0){
                    answer[i] = time[i];
                    q.offer(i);
                }
            }

            while(!q.isEmpty()){
                int now = q.poll();

                for(int node : graph.get(now)){
                    indegree[node]--;
                    answer[node] = Math.max(answer[node],answer[now]+time[node]);
                    if(indegree[node] == 0) q.offer(node);
                }
            }

            sb.append(answer[w]).append("\n");

        }

        System.out.print(sb);
    }
}
