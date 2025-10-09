
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

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N+1];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for(int i=0;i<N+1;i++){
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            indegree[b]++;
        }

        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=1;i<N+1;i++){
            if(indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()){
            int now = q.poll();

            for(int g:graph.get(now)){
                indegree[g]--;

                if(indegree[g] == 0) q.offer(g);
            }

            answer.add(now);
        }

        for(int i=0;i<answer.size();i++){
            System.out.print(answer.get(i)+" ");
        }
    }

}
