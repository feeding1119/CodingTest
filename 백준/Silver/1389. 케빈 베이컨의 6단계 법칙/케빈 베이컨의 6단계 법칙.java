

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
        int m = Integer.parseInt(st.nextToken());

        boolean[][] user = new boolean[n+1][n+1];

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            user[a][b] = true;
            user[b][a] = true;

        }

        int maxUser = 0;
        int minLength = Integer.MAX_VALUE;

        for(int i=1;i<=n;i++){
            Queue<int[]> q = new LinkedList<>();
            boolean[][] v = new boolean[n+1][n+1];

            q.offer(new int[]{i,0});

            int tempLen = 0;

            while(!q.isEmpty()){
                int[] temp = q.poll();

                int u = temp[0];
                int l = temp[1];

                tempLen += l;

                for(int j=1;j<=n;j++){
                    if(user[u][j] && !v[u][j]){
                        q.offer(new int[]{j,l+1});
                        v[u][j] = true;
                    }
                }
            }

            if(minLength > tempLen){
                maxUser = i;
                minLength = tempLen;
            }
        }

        System.out.println(maxUser);

    }
}
