

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        System.out.println(calcFunc(n));
    }

    public static int calcFunc(int n){
        int total = 0;
        int answer = 5;

        int m = (int)Math.sqrt(n);

        int[] num = new int[m+1];

        for(int i=0;i<=m;i++) num[i] = i*i;

        for(int i=m;i>=0;i--){
            total = num[i];

            if(total == n) return 1;

            for(int j=i;j>=0;j--){
                if(total + num[j] > n) continue;

                if(total + num[j] == n){
                    answer = Math.min(answer,2);
                    continue;
                }

                for(int k = j; k>=0;k--){
                    if(total + num[j] + num[k] > n) continue;

                    if(total + num[j] + num[k] == n) {
                        answer = Math.min(answer,3);
                        continue;
                    }

                    for(int l = k;l>=0;l--){
                        if(total + num[j] + num[k] + num[l] > n) continue;

                        if(total + num[j] + num[k] + num[l] == n) {
                            answer = Math.min(answer,4);
                            continue;
                        }
                    }
                }
            }
        }

        return answer;
    }


}
