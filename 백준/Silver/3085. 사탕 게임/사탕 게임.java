import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] candy = new char[N][N];

        for(int i=0;i<N;i++){
            String temp = br.readLine();
            for(int j=0;j<N;j++){
                candy[i][j] = temp.charAt(j);
            }
        }


        System.out.println(transCandy(candy,N));
    }

    static private int transCandy(char[][] candy,int N){
        int answer = 0;

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        for(int i=0;i<N;i++){
            for(int j=1;j<N;j++){
                for(int k=0;k<4;k++){
                    int nx = i+dx[k];
                    int ny = j+dy[k];

                    if(nx >= 0 && ny >= 0 && nx < N && ny < N){
                        if(candy[i][j] != candy[nx][ny]){
                            char temp = candy[i][j];

                            candy[i][j] = candy[nx][ny];
                            candy[nx][ny] = temp;

                            int v = calcMaxCandy(candy,N);
                            if(v > answer) answer = v;

                            temp = candy[i][j];

                            candy[i][j] = candy[nx][ny];
                            candy[nx][ny] = temp;
                        }
                    }
                }
            }
        }

        return answer;
    }

    static private int calcMaxCandy(char[][] candy,int N){
        int count = 1;

        for(int i=0;i<N;i++){
            int temp = 1;
            char prev = candy[i][0];
            for(int j=1;j<N;j++){
                if(candy[i][j] == prev){
                    temp++;
                }else{
                    if(count < temp) count = temp;
                    temp = 1;
                    prev = candy[i][j];
                }
            }

            if(temp != 1 && count < temp) count = temp;
        }

        for(int i=0;i<N;i++){
            int temp = 1;
            char prev = candy[0][i];
            for(int j=1;j<N;j++){
                if(candy[j][i] == prev){
                    temp++;
                }else{
                    if(count < temp) count = temp;
                    temp = 1;
                    prev = candy[j][i];
                }
            }

            if(temp != 1 && count < temp) count = temp;
        }
        return count;
    }
}
