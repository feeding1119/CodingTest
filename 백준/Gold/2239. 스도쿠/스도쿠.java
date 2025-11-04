

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static final int n = 9;
    static int[][] map = new int[n][n];
    static List<int[]> blank = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0;i<n;i++){
            String input = br.readLine();;

            for(int j=0;j<n;j++){
                int temp = input.charAt(j) - '0';
                map[i][j] = temp;
                if(temp == 0) blank.add(new int[]{i,j});
            }
        }

        dfs(0);

    }

    public static void dfs(int idx){

        if(idx == blank.size()){
            printMap();
            System.exit(0);
        }

        for(int k=1;k<=n;k++){
            int[] temp = blank.get(idx);
            if(checkAll(temp[0],temp[1],k)){
                map[temp[0]][temp[1]] = k;
                dfs(idx+1);
                map[temp[0]][temp[1]] = 0;
            }
        }

    }

    public static void printMap(){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    public static boolean checkAll(int x,int y,int num){
        if(!checkX(x,num)) return false;
        if(!checkY(y,num)) return false;
        if(!checkArea(x,y,num)) return false;

        return true;

    }

    public static boolean checkX(int x,int num){

        for(int j=0;j<n;j++){
            if(map[x][j] == num) return false;
        }

        return true;
    }

    public static boolean checkY(int y,int num){

        for(int i=0;i<n;i++){
            if(map[i][y] == num) return false;
        }

        return true;
    }

    public static boolean checkArea(int x,int y,int num){

        int startX = (x/3) * 3;
        int startY = (y/3) * 3;
        for(int i=startX;i<startX+3;i++){
            for(int j=startY;j<startY+3;j++){
                if(map[i][j] == num) return false;
            }
        }

        return true;
    }
}
