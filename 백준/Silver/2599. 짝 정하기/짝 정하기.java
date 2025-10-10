

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] std = new int[3][2];

        StringTokenizer st;

        for(int i=0;i<3;i++){
            st = new StringTokenizer(br.readLine());

            std[i][0] = Integer.parseInt(st.nextToken());
            std[i][1] = Integer.parseInt(st.nextToken());
        }

        if(std[0][0] > std[1][1]+std[2][1] || std[1][0] > std[0][1]+std[2][1] || std[2][0] > std[0][1]+std[1][1]){
            System.out.println(0);
            return;
        }

        int ab,ac,ba,bc,ca,cb;

        for(ab=0;ab<=std[0][0];ab++){
            ac = std[0][0] - ab;
            bc = std[2][1] - ac;
            ba = std[1][0] - bc;
            ca = std[0][1] - ba;
            cb = std[1][1] - ab;

            if(bc >= 0 && ba >= 0 && ca >= 0 && cb >= 0){
                System.out.println(1);
                System.out.println(ab + " " + ac);
                System.out.println(ba + " " + bc);
                System.out.println(ca + " " + cb);
                return;
            }
        }
    }
}
