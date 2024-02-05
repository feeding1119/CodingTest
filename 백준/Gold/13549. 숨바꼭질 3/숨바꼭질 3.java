import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Deque<int[]> q = new ArrayDeque<>();
        int[] visited = new int[200000];
        Arrays.fill(visited,-1);

        q.add(new int[]{N,0});
        visited[N]=0;

        while(!q.isEmpty()){
            int[] value = q.poll();
            int X = value[0];
            int time = value[1];

            int[] nextX = {X*2,X-1,X+1};

            for(int i=0;i<3;i++){
                if(nextX[i]>=0 && nextX[i]<200000 && visited[nextX[i]] == -1) {
                    if (i == 0) {
                        q.addFirst(new int[]{nextX[i], time});
                        visited[nextX[i]] = time;
                    } else {
                        q.addLast(new int[]{nextX[i], time + 1});
                        visited[nextX[i]] = time+1;
                    }
                }
            }

        }

        System.out.println(visited[K]);

    }
}
