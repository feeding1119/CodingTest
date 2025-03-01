import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] v = new boolean[n][n];
        for(int i=0;i<n;i++){

            Queue<Integer> q = new LinkedList<>();

            q.offer(i);

            while(!q.isEmpty()){
                int temp = q.poll();

                for(int j=0;j<n;j++){
                    if(map[temp][j] == 1 && !v[i][j]){
                        q.offer(j);
                        v[i][j] = true;
                    }
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(v[i][j]) System.out.print("1 ");
                else System.out.print("0 ");
            }
            System.out.println();
        }
    }
}
