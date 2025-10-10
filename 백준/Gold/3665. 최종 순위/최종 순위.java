

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for(int i=0;i<t;i++){
            int n = Integer.parseInt(br.readLine());
            int[] ranking = new int[n+1];
            boolean[][] edges = new boolean[n+1][n+1];
            int[] indegree = new int[n+1];

            st = new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++){
                ranking[j] = Integer.parseInt(st.nextToken());
                indegree[ranking[j]] = j-1;
            }

            for(int j=1;j<n+1;j++){
                for(int k=j+1;k<n+1;k++){
                    edges[ranking[j]][ranking[k]] = true;
                }
            }

            int m = Integer.parseInt(br.readLine());

            for(int j=0;j<m;j++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if(edges[a][b]){
                    edges[a][b] = false;
                    edges[b][a] = true;
                    indegree[a]++;
                    indegree[b]--;
                }else{
                    edges[a][b] = true;
                    edges[b][a] = false;
                    indegree[a]--;
                    indegree[b]++;
                }
            }

            Queue<Integer> q = new LinkedList<>();

            for(int j=1;j<n+1;j++){
                if(indegree[j] == 0) q.offer(j);
            }

            StringBuilder sb = new StringBuilder();

            for(int j=1;j<n+1;j++){
                if(q.isEmpty()){
                    sb = new StringBuilder();
                    sb.append("IMPOSSIBLE");
                    break;
                }

                if(q.size()>1){
                    sb = new StringBuilder();
                    sb.append("?");
                    break;
                }

                int now = q.poll();
                sb.append(now+" ");

                for(int k=1;k<n+1;k++){
                    if(edges[now][k]){
                        edges[now][k] = false;
                        indegree[k]--;
                        if(indegree[k] == 0) q.offer(k);
                    }
                }

            }

            System.out.println(sb);



        }


    }
}
