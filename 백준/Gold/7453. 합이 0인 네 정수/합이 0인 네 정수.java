
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] A = new int[n];
        int[] B = new int[n];
        int[] C = new int[n];
        int[] D = new int[n];

        StringTokenizer st;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        int[] AB = new int[n*n];
        int[] CD = new int[n*n];


        int idx = 0;

        for(int a : A){
            for(int b : B){
                AB[idx++] = a+b;
            }
        }

        idx = 0;
        for(int c : C){
            for(int d : D){
                CD[idx++] = c+d;
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        long answer = 0;

        int left = 0;
        int right = n*n-1;

        while(left < n*n && right >= 0){
            long sum = (long)AB[left] + CD[right];

            if(sum == 0){
                int ab = AB[left];
                int cd = CD[right];

                int abCount = 0;
                int cdCount = 0;

                while(left < n*n && AB[left] == ab){
                    left++;
                    abCount++;
                }


                while(right >=0 && CD[right] == cd){
                    right--;
                    cdCount++;
                }

                answer += (long)abCount * cdCount;
            }else if(sum < 0){
                left++;
            }else if(sum > 0){
                right--;
            }
        }

        System.out.println(answer);
    }
}
