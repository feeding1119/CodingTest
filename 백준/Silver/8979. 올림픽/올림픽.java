import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] medal = new int[N][4];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int country = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            medal[i][0] = country;
            medal[i][1] = gold;
            medal[i][2] = silver;
            medal[i][3] = bronze;
        }

        Arrays.sort(medal, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    if(o1[2] == o2[2]){
                        if(o1[3] > o2[3]) return -1;
                        else return 1;
                    }
                    return o2[2] - o1[2];
                }

                return o2[1] - o1[1];
            }
        });

        int answer = 0;
        for(int i=0;i<medal.length;i++){
            if(medal[i][0] == K){
                answer = i;
                break;
            }
        }

        int count = 0;
        for(int i=answer-1; i>=0;i--){
            if(medal[i][3] == medal[answer][3] && medal[i][1] == medal[answer][1] && medal[i][2] == medal[answer][2]){
                count++;
            }else break;
        }

        System.out.println(answer+1-count);
    }
}
