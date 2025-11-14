

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for(int tc=0;tc<t;tc++){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());

            int[] num = new int[n];
            int[] sum= new int[n+1];

            for(int i=0;i<n;i++){
                num[i] = Integer.parseInt(st.nextToken());

                sum[i+1] = sum[i] + num[i];
            }

            ArrayList<Integer> answer = new ArrayList<>();

            for(int i=2;i<=n;i++){
                for(int j=0;j<=n-i;j++){
                    int total = sum[j+i] - sum[j];

                    if(isPrime(total)){
                        for(int k=j;k<j+i;k++){
                            answer.add(num[k]);
                        }
                        break;
                    }
                }
                if(answer.size()!=0) break;
            }

            if(answer.size() == 0){
                sb.append("This sequence is anti-primed.").append("\n");
            }else{
                sb.append("Shortest primed subsequence is length ").append(answer.size()).append(":");

                for(int l : answer){
                    sb.append(" ").append(l);
                }

                sb.append("\n");
            }
        }

        System.out.println(sb);



    }

    public static boolean isPrime(int a){

        if(a==0 || a==1) return false;

        for(int i=2;i<=Math.sqrt(a);i++){
            if(a%i == 0) return false;
        }

        return true;
    }


}
