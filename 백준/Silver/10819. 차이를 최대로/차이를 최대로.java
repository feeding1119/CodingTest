

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int answer = 0;
    static int[] num;
    static boolean[] isUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num = new int[N];
        isUsed = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            num[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num);

        int[] tempNumbers = new int[N];
        dfs(tempNumbers,0);

        System.out.println(answer);
    }

    private static void dfs(int[] numbers,int len){
        if(len == N){
            int temp = calcSum(numbers);
            if(answer < temp) answer = temp;
        }

        for(int i=0;i<N;i++){
            if(!isUsed[i]){
                isUsed[i] = true;
                numbers[len] = num[i];
                dfs(numbers,len+1);
                isUsed[i] = false;
            }
        }
    }

    private static int calcSum(int[] numbers){
        int total =0;
        for(int i=1;i<N;i++){
            total += Math.abs(numbers[i] -numbers[i-1]);
        }

        return total;
    }
}
