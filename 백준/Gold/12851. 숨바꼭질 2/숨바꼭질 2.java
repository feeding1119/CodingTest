import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();

        int time = Integer.MAX_VALUE;
        int INF = 100001;
        int count = 0;

        q.offer(new int[]{n,0});

        boolean[] v = new boolean[INF*2];

        v[n+INF] = true;
        while(!q.isEmpty()){
            int[] temp = q.poll();

            if(temp[1] > time) continue;

            if(temp[0] == k){
                if(temp[1] == time) count++;
                if(temp[1] < time){
                    time = temp[1];
                    count = 1;
                }

                continue;
            }

            v[temp[0]] = true;

            if(temp[0]+1 < 2*INF && !v[temp[0]+1]){
                q.offer(new int[]{temp[0]+1,temp[1]+1});
            }

            if(temp[0]-1 >= 0 && !v[temp[0]-1]){
                q.offer(new int[]{temp[0]-1,temp[1]+1});
            }

            if(temp[0]*2 < 2*INF) {
                if(!v[temp[0]*2]){
                    q.offer(new int[]{temp[0]*2,temp[1]+1});
                }
            }
        }


        System.out.println(time);
        System.out.println(count);
    }
}
