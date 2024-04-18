

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] words = new String[N];

        int wordLen = 0;

        for(int i=0;i<N;i++){
            words[i] = br.readLine();
            wordLen += words[i].length();
        }

        int wordQuotient = (M-wordLen)/(N-1);
        int wordRemain = (M-wordLen)%(N-1);

        String answer = words[0];
        for(int i=1;i<N;i++){
            if(!Character.isUpperCase(words[i].charAt(0))){
                if(wordRemain != 0){
                    for(int j=0;j<=wordQuotient;j++){
                        answer +="_";
                    }
                    wordRemain--;
                }else{
                    for(int j=0;j<wordQuotient;j++){
                        answer +="_";
                    }
                }
            }else{
                if(N-i == wordRemain){
                    for(int j=0;j<=wordQuotient;j++){
                        answer +="_";
                    }
                    wordRemain--;
                }else{
                    for(int j=0;j<wordQuotient;j++){
                        answer +="_";
                    }
                }
            }

            answer += words[i];
        }

        System.out.println(answer);

    }
}
