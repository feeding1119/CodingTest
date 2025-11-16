

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long countOnes(long x) {
        long total = 0;

        for (int i = 0; i < 61; i++) {
            long cycle = 1L << (i + 1); // 2^(i+1)
            long half = 1L << i;        // 2^i

            long fullCycles = (x + 1) / cycle; // 몇 개의 완전한 사이클이 있는지
            long remain = (x + 1) % cycle;     // 남는 부분

            total += fullCycles * half;        // 사이클에서 나오는 1의 개수

            // 남는 부분에서 1이 나오는 부분
            if (remain > half) {
                total += remain - half;
            }
        }

        return total;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long result = countOnes(b) - countOnes(a - 1);
        System.out.println(result);
    }
}
