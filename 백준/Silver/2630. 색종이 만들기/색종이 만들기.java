
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] count = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        int[][] paper = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<n;j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,n,0,n,paper);

        System.out.println(count[0]);
        System.out.println(count[1]);
    }

    public static void dfs(int sX,int eX,int sY,int eY,int[][] paper){
        if(isSquare(sX,eX,sY,eY,paper)){
            count[paper[sX][sY]]++;
            return;
        }

        dfs(sX,(sX+eX)/2,sY,(sY+eY)/2,paper);
        dfs((sX+eX)/2,eX,(sY+eY)/2,eY,paper);
        dfs(sX,(sX+eX)/2,(sY+eY)/2,eY,paper);
        dfs((sX+eX)/2,eX,sY,(sY+eY)/2,paper);

    }

    public static boolean isSquare(int sX,int eX,int sY,int eY,int[][] paper){

        // System.out.println("x : ("+sX+","+eX+") y : ("+sY+","+eY+")" );
        int color = paper[sX][sY];
        for(int i=sX;i<eX;i++){
            for(int j=sY;j<eY;j++){
                if(color != paper[i][j]) return false;
            }
        }

        return true;
    }
}
