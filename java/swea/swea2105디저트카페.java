import java.util.*;
import java.io.*;

public class swea2105디저트카페 {

	static int N, result, arr[][];
	static boolean[] check;

	public static void go(int sx, int sy, int x, int y, int d, int sum) {
		if (x == sx && y == sy) {
			result = Math.max(result, sum);
			return;
		}

		if (x < 0 || y < 0 || x >= N || y >= N || check[arr[x][y]])
			return;

		check[arr[x][y]] = true;

		if (d == 0) {
			go(sx, sy, x + 1, y + 1, 0, sum + 1);
			go(sx, sy, x + 1, y - 1, 1, sum + 1);
		} else if (d == 1) {
			go(sx, sy, x + 1, y - 1, 1, sum + 1);
			go(sx, sy, x - 1, y - 1, 2, sum + 1);
		} else if (d == 2) {
			go(sx, sy, x - 1, y - 1, 2, sum + 1);
			go(sx, sy, x - 1, y + 1, 3, sum + 1);
		} else {
			go(sx, sy, x - 1, y + 1, 3, sum + 1);
		}

		check[arr[x][y]] = false;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			result = -1;
			check = new boolean[101];
			arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < N - 2; i++) {
				for (int j = 1; j < N - 1; j++) {
					check = new boolean[101];
					check[arr[i][j]] = true;
					go(i, j, i + 1, j + 1, 0, 1);
				}
			}

			System.out.println("#"+t+" "+result);
		}
	}
}
