
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        final int INF = 100000001;

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] party = new int[n+1][n+1];

        for(int i=1;i<n+1;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<n+1;j++){
                party[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int k=1;k<n+1;k++){
            for(int i=1;i<n+1;i++){
                for(int j=1;j<n+1;j++){
                    if(party[i][j] > party[i][k] + party[k][j] ){
                        party[i][j] = party[i][k] + party[k][j];
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(party[a][b] <= c) sb.append("Enjoy other party").append("\n");
            else sb.append("Stay here").append("\n");
        }

        System.out.println(sb);
    }
}
