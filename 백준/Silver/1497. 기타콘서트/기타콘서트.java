
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int answer = Integer.MAX_VALUE;
    static int maxPlay = 0;
    static long[] guitarBit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        guitarBit = new long[n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            String g = st.nextToken();
            String song = st.nextToken();

            for(int j=0;j<m;j++){
                if(song.charAt(j) == 'Y') guitarBit[i] |= (1L << j);
            }
        }

        dfs(0,0L,0);

        if(answer == 0) answer = -1;

        System.out.println(answer);

    }

    public static void dfs(int idx,long guitarMask,int g){
        int bitCount = Long.bitCount(guitarMask);

        if(bitCount == maxPlay && g < answer){
            answer = g;
        }

        if(bitCount > maxPlay){
            maxPlay = bitCount;
            answer = g;
        }

        if(idx == n || g == m) return;

        dfs(idx+1,guitarMask | guitarBit[idx], g+1);
        dfs(idx+1,guitarMask,g);


    }

}
