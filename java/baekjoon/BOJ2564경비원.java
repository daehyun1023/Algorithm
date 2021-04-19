import java.util.*;
import java.io.*;

public class BOJ2564경비원 {

	static int W, H, N, dg, result = 0, round;
	static int[] stores;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		W = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(br.readLine());
		stores = new int[N];
		round = 2 * (W + H);
		for (int i = 0; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if (i == N)
				dg = change(a, b);
			else {
				stores[i] = change(a, b);
			}
		}

		for (int i = 0; i < N; i++) {
			int store = stores[i];
			int max = Math.max(store, dg);
			int min = Math.min(store, dg);
			result += Math.min(max - min, (min + round - max));
			
		}
		System.out.println(result);
	}

	private static int change(int a, int b) {
		// 북쪽
		if (a == 1) {
			return b;
		}
		// 동쪽
		else if (a == 4) {
			return W + b;
		}
		// 남쪽
		else if (a == 2) {
			return W + H + W- b;
		}
		// 서쪽
		else {
			return W * 2 + H + H - b;
		}
	}

}
