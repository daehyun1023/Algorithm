import java.util.*;

public class swea1859 {

	static int N;
	static int[] arr;
	static long result;

	static int find_max(int start) {
		int max = Integer.MIN_VALUE;
		int idx = start;
		for (int i = start; i < N; i++) {
			if (max <= arr[i]) {
				max = arr[i];
				idx = i;
			}
		}

		return idx;
	}

	public static void solve(int start_idx, int max_idx) {
		if(start_idx==N) {
			return;
		}
		
		for (int i = start_idx; i <= max_idx; i++) {
			result += (arr[max_idx] - arr[i]);
		}
		
		
		start_idx = max_idx + 1;
		if(start_idx == N) {
			return;
		}
		
		max_idx = find_max(start_idx);
		
		solve(start_idx, max_idx);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N];
			result = 0;
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			int max_idx = find_max(0);
			solve(0, max_idx);

			System.out.println("#" + t + " " + result);
		}
	}

}
