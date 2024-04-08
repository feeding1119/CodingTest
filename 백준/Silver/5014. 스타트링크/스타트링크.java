
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int F,S,G,U,D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F];

        bfs(S-1);
    }

    static void bfs(int s){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{s,0});
        visited[s] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();

            if(temp[0]==G-1){
                System.out.println(temp[1]);
                return;
            }

            int up = temp[0]+U;
            int down = temp[0]-D;

            if(up < F){
                if(!visited[up]) {
                    visited[up] = true;
                    q.offer(new int[]{up,temp[1]+1});
                }
            }

            if(down >=0){
                if(!visited[down]) {
                    visited[down] = true;
                    q.offer(new int[]{down,temp[1]+1});
                }
            }
        }

        System.out.println("use the stairs");
    }
}
