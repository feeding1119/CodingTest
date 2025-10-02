

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][][] board;
    static int n = 5;
    static int[] dx = {1,-1,0,0,0,0};
    static int[] dy = {0,0,1,-1,0,0};
    static int[] dz = {0,0,0,0,1,-1};
    static boolean[] isUsed;
    static int[][][] cube;

    static int answer = Integer.MAX_VALUE;

    public static class Node{
        int x,y,z,cost;

        public Node(int x,int y,int z,int cost){
            this.x = x;
            this.y = y;
            this.z = z;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        board = new int[n][n][n];
        isUsed = new boolean[n];
        cube = new int[n][n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                st = new StringTokenizer(br.readLine());
                for(int k=0;k<n;k++){
                    board[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        dfs(0);




        if(answer == Integer.MAX_VALUE) answer = -1;

        System.out.println(answer);

    }

    public static void printCube(){
        System.out.println("===========");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    System.out.print(cube[i][j][k]+" ");
                }
                System.out.println();
            }

        }
        System.out.println("===========");
    }





    public static void dfs(int depth){
        if(depth == 5){
            escapeCube(cube);
            return;
        }

        for(int i=0;i<n;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                for(int j=0;j<4;j++){
                    turnMap(depth,i,j);
                    dfs(depth+1);
                }
                isUsed[i] = false;
            }
        }

    }


    public static void turnMap(int depth,int idx,int count){

        int[][] result = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                result[i][j] = board[idx][i][j];
            }
        }

        for(int i=0;i<count;i++){
            int[][] temp = new int[n][n];

            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    temp[j][k] = result[k][n-1-j];
                }
            }

            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    result[j][k] = temp[j][k];
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                cube[depth][i][j] = result[i][j];
            }
        }
    }

    public static void escapeCube(int[][][] cube){

        if(cube[0][0][0] == 0 || cube[n-1][n-1][n-1] == 0) return;

        Queue<Node> q = new LinkedList<>();
        boolean[][][] v = new boolean[n][n][n];

        q.offer(new Node(0,0,0,0));
        v[0][0][0] = true;

        while(!q.isEmpty()){
            Node now = q.poll();

            if(now.x == n-1 && now.y == n-1 && now.z == n-1){
                answer = Math.min(answer,now.cost);
                return;
            }

            for(int i=0;i<6;i++){
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];
                int nz = now.z + dz[i];

                if(nx >= 0 && ny >= 0 && nz >= 0 && nx < n && ny < n && nz < n && !v[nx][ny][nz] && cube[nx][ny][nz] == 1){
                    v[nx][ny][nz] = true;

                    q.offer(new Node(nx,ny,nz,now.cost+1));
                }
            }
        }
    }
}
