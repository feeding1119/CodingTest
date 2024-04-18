

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String color = br.readLine();


        int answer = Integer.MAX_VALUE;
        //R을 왼쪽으로
        boolean isNotFirst = false;
        int count = 0;
        for(int i=0;i<color.length();i++){
            if(color.charAt(i) == 'B' && !isNotFirst){
                isNotFirst = true;
                continue;
            }

            if(color.charAt(i) == 'R' && isNotFirst){
                count++;
            }
        }

        answer = Math.min(answer,count);

        //B을 왼쪽으로
        isNotFirst = false;
        count = 0;
        for(int i=0;i<color.length();i++){
            if(color.charAt(i) == 'R' && !isNotFirst){
                isNotFirst = true;
                continue;
            }

            if(color.charAt(i) == 'B' && isNotFirst){
                count++;
            }
        }

        answer = Math.min(answer,count);

        //R을 오른쪽으로
        isNotFirst = false;
        count = 0;
        for(int i=color.length()-1;i>=0;i--){
            if(color.charAt(i) == 'B' && !isNotFirst){
                isNotFirst = true;
                continue;
            }

            if(color.charAt(i) == 'R' && isNotFirst){
                count++;
            }
        }

        answer = Math.min(answer,count);

        //B을 왼쪽으로
        isNotFirst = false;
        count = 0;
        for(int i=color.length()-1;i>=0;i--){
            if(color.charAt(i) == 'R' && !isNotFirst){
                isNotFirst = true;
                continue;
            }

            if(color.charAt(i) == 'B' && isNotFirst){
                count++;
            }
        }

        answer = Math.min(answer,count);

        System.out.println(answer);
    }
}
