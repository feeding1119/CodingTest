import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            String input = br.readLine();

            int score = 0;
            int d = 0;

            boolean flag = false;
            for(int j=0;j<input.length();j++){
                char c = input.charAt(j);

                int s = getScore(c);

                if(score/10 < (score+s)/10){
                    int temp = (score+s)/10;

                    if(temp > 4){
                        sb.append(d).append("(09)").append("\n");
                        flag = true;
                        break;
                    }else if(temp == 4){
                        sb.append(d).append("(weapon)").append("\n");
                        flag = true;
                        break;
                    }else{
                        d += temp;
                    }

                }

                score += s;
            }

            if(!flag) sb.append(d).append("\n");
        }

        System.out.println(sb);
    }

    public static int getScore(char c){
        if(c >= 'A'){
            return 10 + c - 'A';
        }

        return c - '0';
    }
}
