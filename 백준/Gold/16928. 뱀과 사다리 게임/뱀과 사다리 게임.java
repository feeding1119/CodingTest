
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M;
    static int[] map = new int[101];
    static boolean[] v = new boolean[101];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N+M;i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x] = y;


        }
        int answer = bfs();

        System.out.println(answer);
    }

    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{1,0});

        while(!q.isEmpty()){
            int[] temp = q.poll();

            for(int i=1;i<=6;i++){
                int x = temp[0]+i;

                if(x==100) return temp[1]+1;

                if(!v[x]){
                    if(map[x] == 0){
                        q.add(new int[]{x,temp[1]+1});
                    }else{
                        q.add(new int[]{map[x],temp[1]+1});
                    }

                    v[x] =true;
                }

            }
        }

        return -1;
    }
}
