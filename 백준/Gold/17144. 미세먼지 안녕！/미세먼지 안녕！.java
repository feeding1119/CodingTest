
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{
    
    static int r,c,t;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};
    static int[] ac;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        t = Integer.parseInt(st.nextToken());

        map = new int[r][c];
        int[][] newMap = new int[r][c];

        ac = new int[2];

        int idx = 0;
        for(int i=0;i<r;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<c;j++){
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                newMap[i][j] = temp;

                if(temp == -1){
                    ac[idx] = i;
                    idx++;
                }
            }
        }


        for(int i=0;i<t;i++){
            newMap = runProcess(newMap);
            //printMap(newMap);
        }

        System.out.println(calcMap(newMap));
    }

    public static void printMap(int[][] newMap){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(newMap[i][j]+" ");
            }
            System.out.println();

        }
        System.out.println();
    }

    public static int calcMap(int[][] newMap){

        int ans = 0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ans += newMap[i][j];
            }
        }

        return ans;
    }


    public static int[][] runProcess(int[][] newMap){
        int[][] result = new int[r][c];

        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(map[i][j] == -1) continue;

                if(newMap[i][j] < 5){
                    result[i][j] += newMap[i][j];
                    continue;
                }


                ArrayList<Integer> dirList = new ArrayList<>();

                for(int k=0;k<4;k++){
                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(nx >= 0 && ny >= 0 && nx < r && ny < c && map[nx][ny] != -1){
                        dirList.add(k);
                    }
                }

                if(dirList.size() == 0){
                    result[i][j] += newMap[i][j];
                    continue;
                }

                for(int d : dirList){
                    result[i+dx[d]][j+dy[d]] += newMap[i][j]/5;
                }

                result[i][j] += newMap[i][j] -newMap[i][j]/5 * dirList.size();
            }
        }

        runAC(result);

        return result;
    }

    public static void runAC(int[][] result){

        int ac1x = ac[0];

        for(int i=ac1x-1;i>0;i--){
            result[i][0] = result[i-1][0];
        }

        for(int j=0;j<c-1;j++){
            result[0][j] = result[0][j+1];

        }

        for(int i=0;i<ac1x;i++){
            result[i][c-1] = result[i+1][c-1];
        }

        for(int j=c-1;j>0;j--){
            result[ac1x][j] = result[ac1x][j-1];
        }

        int ac2x = ac[1];

        for(int i=ac2x+1;i<r-1;i++){
            result[i][0] = result[i+1][0];
        }

        for(int j=0;j<c-1;j++){
            result[r-1][j] = result[r-1][j+1];

        }

        for(int i=r-1;i>ac2x;i--){
            result[i][c-1] = result[i-1][c-1];
        }


        for(int j=c-1;j>0;j--){
            result[ac2x][j] = result[ac2x][j-1];
        }

    }
}
