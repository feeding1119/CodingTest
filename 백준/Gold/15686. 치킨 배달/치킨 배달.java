

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int answer = Integer.MAX_VALUE;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        List<int[]> chicken = new ArrayList<>();

        int count = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                int info = Integer.parseInt(st.nextToken());
                map[i][j] = info;

                if(info == 1) count++;
                if(info == 2) chicken.add(new int[]{i,j});
            }
        }

        dfs(chicken,new boolean[chicken.size()],0,new int[count],0);

        System.out.println(answer);

    }

    public static void dfs(List<int[]> chicken,boolean[] v,int count,int[] dis,int start){
        if(count == m){
            int temp = 0;
            for(int i=0;i<dis.length;i++){
                temp += dis[i];
            }


            if(answer > temp) answer = temp;

            return;
        }

        for(int i=start;i<chicken.size();i++){
            if(!v[i]){
                v[i] = true;
                int[] newDis = calcDistance(chicken.get(i),dis);
                dfs(chicken,v,count+1,newDis,i+1);
                v[i] = false;
            }
        }
    }

    public static int[] calcDistance(int[] xy,int[] dis){
        int[] newDis = new int[dis.length];

        int index = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] == 1){
                    int temp = Math.abs(xy[0]-i)+Math.abs(xy[1]-j);

                    if(dis[index] == 0 || dis[index] > temp) newDis[index] = temp;
                    else newDis[index] = dis[index];

                    index++;
                }
            }
        }

        return newDis;
    }
}
