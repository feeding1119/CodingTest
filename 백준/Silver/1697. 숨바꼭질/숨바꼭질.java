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

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] isVisited = new boolean[100001];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{N,0});

        while(!q.isEmpty()){
            int[] temp = q.poll();

            if(temp[0] == K) {
                System.out.println(temp[1]);
                break;
            }
            
            isVisited[temp[0]] = true;

            if(temp[0]-1 >= 0 && !isVisited[temp[0]-1]) q.offer(new int[]{temp[0]-1,temp[1]+1});
            if(temp[0]+1 <= 100000 && !isVisited[temp[0]+1]) q.offer(new int[]{temp[0]+1,temp[1]+1});
            if(temp[0]*2 <= 100000 && !isVisited[temp[0]*2]) q.offer(new int[]{2*temp[0],temp[1]+1});
        }
    }


}
