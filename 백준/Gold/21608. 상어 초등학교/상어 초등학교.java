
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;

    static int[][] preferSeat;
    static int[] order;

    static int[][] seat;

    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};

    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        preferSeat = new int[N*N+1][4];
        order = new int[N*N];

        seat = new int[N][N];

        StringTokenizer st;

        for(int i=0;i<N*N;i++){
            st= new StringTokenizer(br.readLine());
            int currentIndex = Integer.parseInt(st.nextToken());

            order[i] = currentIndex;

            for(int j=0;j<4;j++){
                preferSeat[currentIndex][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N*N;i++){
            selectSeat(order[i]);
        }

//        for(int i=0;i<N;i++){
//            for(int j=0;j<N;j++){
//                System.out.print(seat[i][j]+" ");
//            }
//            System.out.println();
//        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int value = checkPrefer(i,j,seat[i][j]);

                if(value==1){
                    result += 1;
                }else if(value==2){
                    result += 10;
                }else if(value==3){
                    result += 100;
                }else if(value==4){
                    result += 1000;
                }

            }
        }

        System.out.println(result);
    }

    static void selectSeat(int student){
        Queue<int[]> seatList = new LinkedList<>();

        int maxPrefer = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(seat[i][j] == 0){
                    int preferCount = checkPrefer(i,j,student);

                    if(preferCount > maxPrefer){
                        maxPrefer = preferCount;
                        seatList.clear();
                        seatList.add(new int[]{i, j});
                    }else if(preferCount == maxPrefer){
                        seatList.add(new int[]{i, j});
                    }
                }
            }
        }


        if(seatList.size() == 1){
            int[] position = seatList.poll();
            seat[position[0]][position[1]] = student;
            return;
        }

        Queue<int[]> emptySeatList = new LinkedList<>();

        int maxEmpty = 0;
        while(!seatList.isEmpty()){
            int[] position = seatList.poll();
            int emptyCount = checkEmpty(position[0],position[1]);

            if(emptyCount > maxEmpty){
                maxEmpty = emptyCount;
                emptySeatList.clear();
                emptySeatList.add(new int[]{position[0],position[1]});
            }else if(emptyCount == maxEmpty){
                emptySeatList.add(new int[]{position[0],position[1]});
            }
        }



        if(emptySeatList.size() == 1){
            int[] position = emptySeatList.poll();


            seat[position[0]][position[1]] = student;
            return;
        }

        Queue<int[]> minRowSeatList = new LinkedList<>();

        int minRow = Integer.MAX_VALUE;
        while(!emptySeatList.isEmpty()){
            int[] position = emptySeatList.poll();

            if(minRow>position[0]){
                minRow = position[0];
                minRowSeatList.clear();
                minRowSeatList.add(new int[]{position[0],position[1]});
            }else if(minRow==position[0]){
                minRowSeatList.add(new int[]{position[0],position[1]});
            }
        }

        if(minRowSeatList.size() == 1){
            int[] position = minRowSeatList.poll();
            seat[position[0]][position[1]] = student;
            return;
        }

        Queue<int[]> minColSeatList = new LinkedList<>();

        int minCol = Integer.MAX_VALUE;
        while(!minRowSeatList.isEmpty()){
            int[] position = minRowSeatList.poll();

            if(minCol>position[1]){
                minCol = position[1];
                minColSeatList.clear();
                minColSeatList.add(new int[]{position[0],position[1]});
            }else if(minCol==position[1]){
                minColSeatList.add(new int[]{position[0],position[1]});
            }
        }

        int[] position = minColSeatList.poll();
        seat[position[0]][position[1]] = student;

    }

    static int checkPrefer(int x, int y, int student) {
        int count =0;

        for(int i=0;i<4;i++){
            int target = preferSeat[student][i];

            for(int j=0;j<4;j++){
                int nx = x + dx[j];
                int ny = y + dy[j];

                if(nx>=0 && nx<N && ny>=0 && ny<N && seat[nx][ny] == target){
                    count++;
                    break;
                }
            }
        }
        return count;
    }

    static int checkEmpty(int x, int y) {
        int count =0;

        for(int i=0;i<4;i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && nx<N && ny>=0 && ny<N && seat[nx][ny] == 0){
                count++;
            }
        }
        return count;
    }
}
