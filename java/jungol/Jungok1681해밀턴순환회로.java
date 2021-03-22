import java.util.*;
import java.io.*;

public class Jungok1681해밀턴순환회로 {

	static int N;
	static int[][] arr;
	static boolean[] check, check2;
	static int min = Integer.MAX_VALUE;
	static int min2 = Integer.MAX_VALUE;

	public static void dfs(int x, int cnt, int dist) {
		if (min <= dist) {
			return;
		}

		if (cnt == N - 1 && min > dist) {
			min2 = Integer.MAX_VALUE;
			check2 = new boolean[N];
			check2[x] = true;
			dfs2(x, 0);
			System.out.println(dist);
			min = Math.min(min, dist + min2);
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!check[i] && arr[x][i] != 0) {
				check[i] = true;
				dfs(i, cnt + 1, dist + arr[x][i]);
				check[i] = false;
			}
		}
	}

	public static void dfs2(int x, int dist) {
		if (min2 <= dist) {
			return;
		}

		if (x == 0 && min2 > dist) {
			min2 = dist;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!check2[i] && arr[x][i] != 0) {
				check2[i] = true;
				dfs2(i, dist + arr[x][i]);
				check2[i] = false;
			}
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		check = new boolean[N];
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		check[0] = true;
		dfs(0, 0, 0);

		System.out.println(min);

	}

}
