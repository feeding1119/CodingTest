import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] cleanerDx = {-1,0,1,0};
    static int[] cleanerDy = {0,1,0,-1};
    static int[][] room;
    static int answer = 0;
    static int order = 2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        room = new int[n][m];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        workCleaner(r,c,d);

//        for(int i=0;i<n;i++){
//            for(int j=0;j<m;j++){
//                if(room[i][j] < 10) System.out.print(room[i][j]+"  ");
//                else System.out.print(room[i][j] + " ");
//            }
//            System.out.println();
//        }
        System.out.println(answer);
    }

    public static void workCleaner(int cx,int cy,int cd){

        if(room[cx][cy] == 0){
            answer++;
            room[cx][cy] = order++;
        }

        if(!checkDirty(cx,cy)) {
            int x = cx+cleanerDx[(cd+2)%4];
            int y = cy+cleanerDy[(cd+2)%4];

            if(room[x][y] == 1) return;

            workCleaner(x,y,cd);
        }else{
            cd = turnCleaner(cd);
            int x = cx+cleanerDx[cd];
            int y = cy+cleanerDy[cd];

            if(room[x][y] == 0) workCleaner(x,y,cd);
            else workCleaner(cx,cy,cd);


        }

    }

    public static int turnCleaner(int cd){
        if(cd == 0) return 3;

        return cd-1;
    }

    public static boolean checkDirty(int cx,int cy){
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i=0;i<4;i++){
            int x = cx + dx[i];
            int y = cy + dy[i];

            if(room[x][y] == 0) return true;
        }

        return false;
    }
}
