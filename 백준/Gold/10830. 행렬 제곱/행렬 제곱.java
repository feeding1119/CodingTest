import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int a;
    static long b;
    static final int mod = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Long.parseLong(st.nextToken());

        int[][] matrix = new int[a][a];

        for(int i=0;i<a;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<a;j++){
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] answer = pow(matrix,b);

        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                System.out.print(answer[i][j]%mod + " ");
            }
            System.out.println();
        }
    }

    public static int[][] pow(int[][] matrix,long exp){
        if(exp == 1L){
            return matrix;
        }

        int[][] temp = pow(matrix,exp/2);

        int[][] result = multiMatrix(temp,temp);

        if(exp % 2 == 1){
            return multiMatrix(result,matrix);
        }

        return result;
    }

    public static int[][] multiMatrix(int[][] m1,int[][] m2){
        int[][] result = new int[a][a];

        for(int i=0;i<a;i++){
            for(int j=0;j<a;j++){
                int temp = 0;
                for(int k=0;k<a;k++){
                    temp += m1[i][k] * m2[k][j];
                }
                result[i][j] = temp % mod;
            }
        }


        return result;
    }
}
