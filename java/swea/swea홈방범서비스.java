import java.util.*;
import java.io.*;

public class swea홈방범서비스 {

	static int N, M, cost, result = Integer.MIN_VALUE;
	static int[][] arr;
	static int[][] temp;

	public static void cover(int x, int y, int k) {
		int house = 0;

		for (int i = 1; i <= k - 1; i++) {
			for (int j = y + (-k + 1) + i; j <= y + (k - 1) - i; j++) {
				if (x - 1 < N && x - i >= 0 && j >= 0 && j < N) {
					if (arr[x - i][j] == 1) {
						house += 1;
						cost -= M;
					}
				}
				if (x + i >= 0 && j >= 0 && x + i < N && j < N) {
					if (arr[x + i][j] == 1) {
						house += 1;
						cost -= M;
					}
				}
			}
		}

		for (int j = -(k - 1); j <= (k - 1); j++) {
			if (x < 0 || y + j < 0 || x >= N || y + j >= N)
				continue;
			if (arr[x][y + j] == 1) {
				house += 1;
				cost -= M;
			}
		}

		if (cost <= 0) {
			result = Math.max(result, house);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = temp[i][j];
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			temp = new int[N][N];
			result = Integer.MIN_VALUE;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					temp[i][j] = arr[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					for (int k = 1; k <= N + 1; k++) {
						cost = (k * k) + ((k - 1) * (k - 1));
						cover(i, j, k);
					}
				}
			}

			System.out.println("#" + t + " " + result);
		}

	}

}
