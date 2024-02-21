import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static boolean[] isVisted;
    static int[][] city;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        isVisted = new boolean[N];
        city = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0,0);

        System.out.println(result);
    }

    static void dfs(int index,int cost,int prevCity,int startCity){
        if(index == N){
            if(city[prevCity][startCity] !=0){
                cost += city[prevCity][startCity];
                result = Math.min(result,cost);
            } //마지막에 돌아올 수 있는지 확인
            
            return;
        }

        for(int i=0;i<N;i++){
            if(!isVisted[i]&&(index==0 || city[prevCity][i] != 0)){
                isVisted[i] = true;
                if(index == 0){
                    dfs(index+1,0,i,i);
                }else{
                    dfs(index+1,cost+city[prevCity][i],i,startCity);
                }
                isVisted[i] = false;
            }
        }
    }
}
