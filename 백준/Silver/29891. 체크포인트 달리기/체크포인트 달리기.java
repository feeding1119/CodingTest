import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main { 

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int num = Integer.parseInt(bf.readLine());
			if (num < 0) {
				list1.add(num);
			} else {
				list2.add(num);
			}
		}

		Collections.sort(list1);
		Collections.sort(list2, Collections.reverseOrder());

		long result = 0;
		int cnt = 0;
		for (int i = 0; i < list1.size(); i++) {
			if (cnt == 0) {
				result += Math.abs(list1.get(i)) * 2;
				cnt += 1;
			} else if (cnt < k) {
				cnt += 1;
			}

			if (cnt == k) {
				cnt = 0;
			}
		}

		cnt=0;
		for (int i = 0; i < list2.size(); i++) {
			if (cnt == 0) {
				result += list2.get(i) * 2;
				cnt += 1;
			} else if (cnt < k) {
				cnt += 1;
			}

			if (cnt == k) {
				cnt = 0;
			}
		}
		System.out.println(result);
	}
}