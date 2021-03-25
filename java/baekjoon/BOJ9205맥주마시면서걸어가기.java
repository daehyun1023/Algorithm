import java.util.*;
import java.io.*;

public class BOJ9205맥주마시면서걸어가기 {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static Pair[] location;
	static boolean[] check;
	static boolean result;

	public static void dfs(int idx) {
		if (result) {
			return;
		}

		if (idx == N + 1) {
			result = true;
			return;
		}

		for (int i = 0; i < N + 2; i++) {
			if (check[i] == false
					&& Math.abs(location[idx].x - location[i].x) + Math.abs(location[idx].y - location[i].y) <= 1000) {
				check[i] = true;
				dfs(i);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			location = new Pair[N + 2];
			check = new boolean[N + 2];
			result = false;
			for (int i = 0; i < N + 2; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				location[i] = new Pair(x, y);
			}
			check[0] = true;
			dfs(0);

			System.out.println(result == true ? "happy" : "sad");
		}
	}
}
