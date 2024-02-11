import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[1000];

        for(int i=100; i<1000; i++){
            String num = String.valueOf(i);

            if(num.charAt(0)=='0' || num.charAt(1)=='0' || num.charAt(2)=='0') continue;

            if(num.charAt(0) == num.charAt(1) || num.charAt(1) == num.charAt(2) || num.charAt(2) == num.charAt(0)) continue;

            check[i] = true;
        }

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String num = st.nextToken();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            for(int j=100; j<1000; j++){
                if(check[j]){
                    int s = 0;
                    int b = 0;

                    String temp = String.valueOf(j);

                    for(int k=0;k<3;k++){
                        char first = temp.charAt(k);
                        for(int l=0;l<3;l++){
                            char second = num.charAt(l);

                            if(first==second && k==l) s++;

                            if(first==second && k!=l) b++;
                        }
                    }

                    if(strike == s && ball == b) check[j] = true;
                    else check[j] = false;
                }
            }
        }

        int result = 0;
        for(int i=100;i<1000;i++){
            if(check[i]) result++;
        }

        System.out.println(result);
    }
}
