import java.util.*;
import java.io.*;

public class swea1247 {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N;
	static Pair start;
	static Pair end;
	static Pair[] passenger;
	static int[] numbers;
	static int min;

	public static void permutation(int depth, int mask, int x, int y, int sum) {
		if (sum >= min) {
			return;
		}
		if (depth == N) {
			int dist = sum + Math.abs(x - end.x) + Math.abs(y - end.y);
			min = Math.min(min, dist);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if ((mask & 1<<i) == 0) {
				int dist = Math.abs(x - passenger[i].x) + Math.abs(y - passenger[i].y);
				permutation(depth + 1, mask | 1<<i, passenger[i].x, passenger[i].y, sum + dist);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			start = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			end = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			passenger = new Pair[N];
			numbers = new int[N];
			for (int i = 0; i < N; i++) {
				passenger[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}

			permutation(0, 0, start.x, start.y, 0);
			System.out.println("#"+t+" "+min);
		}

	}

}
