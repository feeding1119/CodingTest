import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int i=0;i<T;i++){
            int I = Integer.parseInt(br.readLine());

            boolean[][] v = new boolean[I][I];

            st = new StringTokenizer(br.readLine());

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            v[startX][startY] = true;

            st = new StringTokenizer(br.readLine());

            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<>();

            q.offer(new int[]{startX,startY,0});

            System.out.println(bfs(q,v,I,endX,endY));

        }
    }

    static int bfs(Queue<int[]> q,boolean[][] v,int I,int endX, int endY){

        int[] dx = {-2,-1,1,2,2,1,-1,-2};
        int[] dy = {1,2,2,1,-1,-2,-2,-1};

        while(!q.isEmpty()){
            int[] temp = q.poll();

            if(temp[0] == endX && temp[1] == endY) return temp[2];

            for(int i=0;i<8;i++){
                int nx = temp[0]+dx[i];
                int ny = temp[1]+dy[i];

                if(nx>=0 && ny>=0 && nx<I && ny<I && !v[nx][ny]) {
                    v[nx][ny] = true;
                    q.offer(new int[]{nx,ny,temp[2]+1});
                }

            }
        }

        return -1;
    }
}
