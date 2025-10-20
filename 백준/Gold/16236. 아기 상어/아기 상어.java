

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;
    static int sharkSize = 2;
    static int sharkExp = 0;
    static int sharkX = 0;
    static int sharkY = 0;
    static PriorityQueue<Fish> fishes;
    static int answer = 0;

    public static class Fish implements Comparable<Fish>{
        int x,y,dist;

        public Fish(int x,int y,int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Fish o){
            if(this.dist == o.dist){
                if(this.x == o.x) return this.y - o.y;
                return this.x - o.x;
            }
            return this.dist - o.dist;
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        fishes = new PriorityQueue<>();

        StringTokenizer st;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp == 9){
                    sharkX = i;
                    sharkY = j;
                    map[i][j] = 0;
                }
            }
        }

        eatFish();

        System.out.println(answer);

    }

    public static void eatFish(){
        findFish();

        while(!fishes.isEmpty()){
            Fish curFish = fishes.poll();

            answer += curFish.dist;
            sharkX = curFish.x;
            sharkY = curFish.y;
            map[sharkX][sharkY] = 0;

            sharkExp++;

            if(sharkExp == sharkSize){
                sharkExp = 0;
                sharkSize++;
            }

            findFish();

        }
    }

    public static void findFish(){
        fishes = new PriorityQueue<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] != 0 && map[i][j] < sharkSize){
                    int dist = calcDist(i,j);
                    if(dist == 0) continue;
                    fishes.offer(new Fish(i,j,dist));
                }
            }
        }
    }

    public static int calcDist(int x,int y){
        Queue<int[]> q = new LinkedList<>();

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        q.offer(new int[]{sharkX,sharkY,0});

        boolean[][] v = new boolean[n][n];
        v[sharkX][sharkY] = true;

        while(!q.isEmpty()){
            int[] temp = q.poll();


            for(int i=0;i<4;i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx >= 0 && ny >= 0 && nx < n && ny <n && !v[nx][ny] && map[nx][ny] <= sharkSize){
                    v[nx][ny] = true;
                    q.offer(new int[]{nx,ny,temp[2]+1});

                    if(nx == x && ny == y){
                        return temp[2]+1;
                    }
                }
            }
        }

        return 0;

    }
}
