
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int n;

    static int solve(char[] origin, char[] target, boolean pressFirst) {
        char[] arr = origin.clone();
        int count = 0;

        if (pressFirst) {
            toggle(arr, 0);
            count++;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != target[i - 1]) {
                toggle(arr, i);
                count++;
            }
        }

        if (Arrays.equals(arr, target)) return count;
        return Integer.MAX_VALUE;
    }

    static void toggle(char[] arr, int idx) {
        for (int i = idx - 1; i <= idx + 1; i++) {
            if (i >= 0 && i < n) {
                arr[i] = (arr[i] == '0') ? '1' : '0';
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        char[] origin = br.readLine().toCharArray();
        char[] target = br.readLine().toCharArray();

        int case1 = solve(origin, target, false);
        int case2 = solve(origin, target, true);

        int answer = Math.min(case1, case2);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);

    }
}
