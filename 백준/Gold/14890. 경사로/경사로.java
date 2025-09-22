

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,l;
    static int[][] map;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<n;i++){
            if(calcHorizontal(i)) answer++;
            if(calcVertical(i)) answer++;
        }

        System.out.println(answer);

    }

    public static boolean calcHorizontal(int x){

        int prevH = map[x][0];
        int prevC = 1;
        boolean check = false;
        for(int i=1;i<n;i++){
            if(check && prevC >= l){
                check = false;
                prevC = 0;
            }

            if(prevH == map[x][i]){
                prevC++;
                continue;
            }

            if(Math.abs(prevH - map[x][i]) != 1 || check) return false;

            if(prevH < map[x][i]){
                if(prevC < l) return false;

            }else{
                check = true;
            }

            prevH = map[x][i];
            prevC = 1;


        }

        if(check && prevC < l) return false;

        return true;
    }

    public static boolean calcVertical(int y){

        int prevH = map[0][y];
        int prevC = 1;
        boolean check = false;
        for(int i=1;i<n;i++){
            if(check && prevC >= l){
                check = false;
                prevC = 0;
            }

            if(prevH == map[i][y]){
                prevC++;
                continue;
            }

            if(Math.abs(prevH - map[i][y]) != 1 || check) return false;

            if(prevH < map[i][y]){
                if(prevC < l) return false;

            }else{
                check = true;
            }

            prevH = map[i][y];
            prevC = 1;

        }

        if(check && prevC < l) return false;

        return true;
    }


}
