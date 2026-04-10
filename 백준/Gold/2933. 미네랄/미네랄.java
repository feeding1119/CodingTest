
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int r,c,n;
    static char[][] map;
    static int[] heights;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for(int i=0;i<r;i++){
            String input = br.readLine();

            for(int j=0;j<c;j++){
                map[i][j] = input.charAt(j);
            }
        }

        n = Integer.parseInt(br.readLine());

        heights = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<n;i++){
            removeMineral(r-heights[i],i );
        }

        printMap();
    }

    public static void removeMineral(int h,int turn){
        boolean isTurn = false;

        if(turn % 2 == 0) isTurn = true;

        if(isTurn){
            for(int j=0;j<c;j++){
                if(map[h][j] == 'x'){
                    map[h][j] = '.';
                    break;
                }
            }
        }else{
            for(int j=c-1;j>=0;j--){
                if(map[h][j] == 'x'){
                    map[h][j] = '.';
                    break;
                }
            }
        }

        int[][] v = new int[r][c];
        int num = 1;

        for(int i=0;i<r;i++){
            for (int j=0;j<c;j++){
                if(map[i][j] == 'x' && v[i][j] == 0){
                    dfs(i,j,num,v);
                    num++;
                }
            }
        }

//        for(int i=0;i<r;i++){
//            for(int j=0;j<c;j++){
//                System.out.print(v[i][j]);
//            }
//            System.out.println();
//        }
//        System.out.println();


        boolean[] check = new boolean[num];

        for(int j=0;j<c;j++){
            check[v[r-1][j]] = true;
        }

        int temp = 0;

        for(int i=1;i<num;i++){
            if(!check[i]){
                temp = i;
                break;
            }
        }

        if(temp !=0){
            fallMineral(temp,v);
        }


    }

    public static void printMap(){
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }

    }

    public static void fallMineral(int num,int[][] v){

        while(true){

            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    if(v[i][j] != num) continue;

                    if(i == r-1) return;

                    if(v[i+1][j] != 0 && v[i+1][j] != num) return;
                }
            }

            moveMineral(num,v);
        }

    }

    public static void moveMineral(int num,int[][] v){

        for(int i=r-2;i>=0;i--){
            for(int j=0;j<c;j++){
                if(v[i][j] == num){
                    v[i][j] = 0;
                    v[i+1][j] =num;

                    map[i][j] = '.';
                    map[i+1][j] = 'x';
                }
            }
        }

    }


    public static void dfs(int x,int y,int num, int[][] v){
        v[x][y] = num;

        for(int i=0;i<4;i++){
            int nx = x+dx[i];
            int ny = y+dy[i];

            if(nx >=0 && ny >=0 && nx < r && ny < c && v[nx][ny] == 0 && map[nx][ny] == 'x'){
                dfs(nx,ny,num,v);
            }
        }
    }
}
