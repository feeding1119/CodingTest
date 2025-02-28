
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];

        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<m;j++){
                int h = Integer.parseInt(st.nextToken());
                map[i][j] = h;

                if(minH > h) minH = h;
                if(maxH < h) maxH = h;
            }
        }

        int answerT = Integer.MAX_VALUE;
        int answerH = 0;

        if(minH == maxH) {
            answerT = 0;
            answerH = minH;
        }

        for(int i=minH;i<=maxH;i++){
            int totalB = b;
            int totalT = 0;

            for(int j=0;j<n;j++){
                for(int k=0;k<m;k++){
                    int temp = i - map[j][k];

                    if(temp > 0) {
                        totalB -= temp;
                        totalT += temp;
                    }

                    if(temp < 0) {
                        totalB += -temp;
                        totalT += -temp*2;
                    }
                }
            }

            if(totalB >=0){
                if(totalT <= answerT){
                    answerT = totalT;
                    answerH = i;
                }
            }

        }

        System.out.println(answerT+" "+answerH);


    }

}
