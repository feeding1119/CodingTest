import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static char[][] map;
    static boolean[][][][] v;
    static int N,M;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        v = new boolean[N][M][N][M];

        int rx=0;
        int ry=0;
        int bx=0;
        int by=0;

        for(int i=0;i<N;i++){
            String input = br.readLine();
            for(int j=0;j<M;j++){
                map[i][j] = input.charAt(j);
                if(input.charAt(j) == 'R'){
                    rx = i;
                    ry = j;
                }

                if(input.charAt(j) == 'B'){
                    bx = i;
                    by = j;
                }
            }
        }


        System.out.print(bfs(new Node(rx,ry,bx,by,0)));

    }

    private static int bfs(Node n){
        Queue<Node> q = new LinkedList<>();

        q.offer(n);
        v[n.rx][n.ry][n.bx][n.by] = true;

        while(!q.isEmpty()){
            Node curNode = q.poll();

            if(curNode.count >= 10) break;

            for(int i=0;i<4;i++){
                int nrx = curNode.rx;
                int nry = curNode.ry;
                int nbx = curNode.bx;
                int nby = curNode.by;

                boolean isFail = false;
                while(true){
                    nbx += dx[i];
                    nby += dy[i];

                    if(map[nbx][nby] == '#'){
                        nbx -= dx[i];
                        nby -= dy[i];
                        break;
                    }

                    if(map[nbx][nby] == 'O'){
                        isFail = true;
                        break;
                    }
                }

                if(isFail) continue;

                while(true){
                    nrx += dx[i];
                    nry += dy[i];

                    if(map[nrx][nry] == '#'){
                        nrx -= dx[i];
                        nry -= dy[i];
                        break;
                    }

                    if(map[nrx][nry] == 'O') return curNode.count+1;
                }


                if(nrx == nbx && nry == nby){
                    if(i == 0){
                        if(curNode.rx < curNode.bx) nbx -= dx[i];
                        if(curNode.rx > curNode.bx) nrx -= dx[i];
                    }

                    if(i == 1){
                        if(curNode.rx < curNode.bx) nrx -= dx[i];
                        if(curNode.rx > curNode.bx) nbx -= dx[i];
                    }

                    if(i == 2){
                        if(curNode.ry < curNode.by) nby -= dy[i];
                        if(curNode.ry > curNode.by) nry -= dy[i];
                    }

                    if(i == 3){
                        if(curNode.ry < curNode.by) nry -= dy[i];
                        if(curNode.ry > curNode.by) nby -= dy[i];
                    }
                }


                // System.out.println("R("+nrx+","+nry+"-B("+nbx+","+nby+")");
                if(v[nrx][nry][nbx][nby]) continue;


                q.offer(new Node(nrx,nry,nbx,nby, curNode.count+1));
                v[nrx][nry][nbx][nby] = true;

            }
        }

        return -1;
    }
}

class Node {
    int rx, ry, bx, by, count;

    public Node(int rx, int ry, int bx, int by, int count) {
        this.rx = rx;
        this.ry = ry;
        this.bx = bx;
        this.by = by;
        this.count = count;
    }
}