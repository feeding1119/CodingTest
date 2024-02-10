import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static String answer = "";
    static int hammingDistance = 0;
    static int N,M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] dna = new char[N][M];

        for(int i=0;i<N;i++){
            String input = br.readLine();

            for(int j=0;j<M;j++){
                dna[i][j] = input.charAt(j);
            }
        }

        for(int j=0;j<M;j++){
            int[] acgt = new int[4];
            for(int i=0;i<N;i++){
                if(dna[i][j] == 'A'){
                    acgt[0]++;
                }else if(dna[i][j] == 'C'){
                    acgt[1]++;
                }else if(dna[i][j] == 'G'){
                    acgt[2]++;
                }else if(dna[i][j] == 'T'){
                    acgt[3]++;
                }
            }
            getHammingDistance(acgt);

        }

        System.out.println(answer);
        System.out.println(hammingDistance);

    }

    static void getHammingDistance(int[] acgt){
        int maxValue = 0;
        int maxIndex = 0;
        for(int i=0;i<4;i++){
            if(acgt[i]>maxValue){
                maxValue = acgt[i];
                maxIndex = i;
            }
        }

        if(maxIndex == 0){
            answer+="A";
        }else if(maxIndex == 1){
            answer+="C";
        }else if(maxIndex == 2){
            answer+="G";
        }else if(maxIndex == 3){
            answer+="T";
        }

        hammingDistance += (N-maxValue);
    }
}
