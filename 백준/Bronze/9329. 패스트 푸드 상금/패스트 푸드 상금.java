import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while(T!=0){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int totalReward = 0;

            List<Integer[]> rewardList = new ArrayList<>();
            Integer[] rewardAmount = new Integer[n];

            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());

                int k = Integer.parseInt(st.nextToken());

                Integer[] reward = new Integer[k];

                for(int j=0;j<k;j++){
                    reward[j] = Integer.parseInt(st.nextToken());
                }
                rewardList.add(reward);

                rewardAmount[i] = Integer.parseInt(st.nextToken());

            }

            st = new StringTokenizer(br.readLine());
            Integer[] stickers = new Integer[m];
            for(int i=0;i<m;i++){
                stickers[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0;i<rewardList.size();i++){
                int minCount = 101;
               for(int sticker :rewardList.get(i)){
                   if(stickers[sticker-1]<minCount){
                       minCount = stickers[sticker-1];
                   }
               }
                totalReward += minCount*rewardAmount[i];
            }

            System.out.println(totalReward);
            T--;
        }

    }

}