import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n,m,c;
    static int[][] map;
    static ArrayList<CCTV> cctvs;
    static int[] dir;

    static int answer = Integer.MAX_VALUE;


    public static class CCTV{
        int x;
        int y;

        public CCTV(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        cctvs = new ArrayList<>();


        map = new int[n][m];


        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp !=0 && temp !=6) cctvs.add(new CCTV(i,j));
                map[i][j] = temp;
            }
        }

        c = cctvs.size();
        dir = new int[c];

        dfs(0);

        System.out.println(answer);

    }

    public static void dfs(int idx){
        if(idx == c){
            checkCCTV(makeCCTVMap());
            return;
        }

        for(int i=0;i<4;i++){
            dir[idx] = i;
            dfs(idx+1);
        }
    }


    public static int[][] makeCCTVMap(){
        int[][] result = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                result[i][j] = map[i][j];
            }
        }

        for(int i=0;i<c;i++){
            CCTV now = cctvs.get(i);

            int cctvNum = map[now.x][now.y];
            if(cctvNum==1){
                if(dir[i] == 0){
                    checkUp(result,now.x,now.y);
                }else if(dir[i] == 1){
                    checkRight(result,now.x,now.y);
                }else if(dir[i] == 2){
                    checkDown(result,now.x,now.y);
                }else if(dir[i] == 3){
                    checkLeft(result,now.x,now.y);
                }
            }else if(cctvNum==2){
                if(dir[i] % 2 == 0){
                    checkUp(result,now.x,now.y);
                    checkDown(result,now.x,now.y);
                }else if(dir[i] % 2 == 1){
                    checkRight(result,now.x,now.y);
                    checkLeft(result,now.x,now.y);
                }
            }else if(cctvNum==3){
                if(dir[i] == 0){
                    checkUp(result,now.x,now.y);
                    checkRight(result,now.x,now.y);
                }else if(dir[i] == 1){
                    checkRight(result,now.x,now.y);
                    checkDown(result,now.x,now.y);
                }else if(dir[i] == 2){
                    checkDown(result,now.x,now.y);
                    checkLeft(result,now.x,now.y);
                }else if(dir[i] == 3){
                    checkLeft(result,now.x,now.y);
                    checkUp(result,now.x,now.y);
                }

            }else if(cctvNum==4){
                if(dir[i] == 0){
                    checkUp(result,now.x,now.y);
                    checkRight(result,now.x,now.y);
                    checkDown(result,now.x,now.y);
                }else if(dir[i] == 1){
                    checkRight(result,now.x,now.y);
                    checkDown(result,now.x,now.y);
                    checkLeft(result,now.x,now.y);
                }else if(dir[i] == 2){
                    checkDown(result,now.x,now.y);
                    checkLeft(result,now.x,now.y);
                    checkUp(result,now.x,now.y);
                }else if(dir[i] == 3){
                    checkLeft(result,now.x,now.y);
                    checkUp(result,now.x,now.y);
                    checkRight(result,now.x,now.y);
                }

            }else if(cctvNum==5){
                checkUp(result,now.x,now.y);
                checkRight(result,now.x,now.y);
                checkDown(result,now.x,now.y);
                checkLeft(result,now.x,now.y);

            }
        }

        return result;

    }

    public static void checkUp(int[][] result, int x,int y){
        for(int i=x-1;i>=0;i--){
            if(result[i][y] == 6) break;
            if(result[i][y] == 0) result[i][y] = -1;
        }

    }

    public static void checkDown(int[][] result, int x,int y){
        for(int i=x+1;i<n;i++){
            if(result[i][y] == 6) break;
            if(result[i][y] == 0) result[i][y] = -1;
        }
    }

    public static void checkRight(int[][] result, int x,int y){
        for(int j=y+1;j<m;j++){
            if(result[x][j] == 6) break;
            if(result[x][j] == 0) result[x][j] = -1;
        }
    }

    public static void checkLeft(int[][] result, int x,int y){
        for(int j=y-1;j>=0;j--){
            if(result[x][j] == 6) break;
            if(result[x][j] == 0) result[x][j] = -1;
        }
    }
    public static void checkCCTV(int[][] fMap){
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(fMap[i][j] == 0) count++;
            }
        }

        if(answer > count) answer = count;
    }
}
