

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int INF = 10000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] bus = new int[n+1][n+1];

        for(int i=1;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                bus[i][j] = INF;

                if(i==j) bus[i][j] = 0;
            }
        }

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            bus[a][b] = Math.min(bus[a][b],c);
        }

        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(bus[i][j] > bus[i][k] + bus[k][j]){
                        bus[i][j] = bus[i][k] + bus[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<n+1;i++){
            for(int j=1;j<n+1;j++){
                if(bus[i][j] == INF) bus[i][j] = 0;

                sb.append(bus[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
