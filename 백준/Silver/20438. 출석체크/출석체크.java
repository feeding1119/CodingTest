import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] nStu = new boolean[N+3];
        List<Integer> SleepStudent = new ArrayList<Integer>();
        int[] qStu = new int[Q];
        int[][] mStu = new int[M][2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            SleepStudent.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<Q;i++){
            int value = Integer.parseInt(st.nextToken());
            if(SleepStudent.contains(value)) continue;
            for (int j = value; j < N + 3; j++) {
                if (j % value == 0) {
                    if (!SleepStudent.contains(j)) nStu[j] = true;
                }
            }
        }

        int[] cumSum = new int[N + 3];
        for (int i = 3; i < cumSum.length; i++) {
            cumSum[i] = cumSum[i - 1] + ((!nStu[i]) ? 1 : 0);
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            System.out.println(cumSum[e] - cumSum[s - 1]);
        }


    }
}
