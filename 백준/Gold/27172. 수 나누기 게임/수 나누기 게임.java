
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        final int MAX = 1000001;

        int[] cards = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++){
            cards[i] = Integer.parseInt(st.nextToken());
        }

        int[] score = new int[MAX];

        Arrays.fill(score,Integer.MAX_VALUE);

        for(int c : cards){
            score[c] = 0;
        }

        for(int i=1;i<MAX;i++){
            if(score[i] != Integer.MAX_VALUE){
                for(int j=i+i;j<MAX;j += i){
                    if(score[j] != Integer.MAX_VALUE){
                        score[i]++;
                        score[j]--;
                    }
                }
            }
        }

        for(int c : cards){
            System.out.print(score[c] +" ");
        }


    }
}
