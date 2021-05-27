package samsung;

import java.io.*;
import java.util.*;

public class BOJ20057_마법사상어와토네이도 {

	static int N, cnt, result, go = 1;
	static int[][] arr, temp;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		temp = new int[N][N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int x = N / 2;
		int y = N / 2;
		int dir = 0;

		while (true) {
			for (int i = 0; i < go; i++) {
				x += dx[dir];
				y += dy[dir];
				solve(x, y, dir);
				if (x == 0 && y == 0)
					break;
			}

			cnt++;
			dir = (dir + 1) % 4;

			if (cnt == 2) {
				go++;
				cnt = 0;
			}

			if (x == 0 && y == 0)
				break;
		}
		System.out.println(result);
	}

	private static void solve(int x, int y, int dir) {
		int sand = arr[x][y];
		int reverseDir = (dir + 2) % 4;
		int clockDir = (dir + 1) % 4;
		int reverseClockDir = (dir + 3) % 4;
		int moveSand = 0;
		// 1% 채우기
		int x1 = (x + dx[reverseDir]) + dx[clockDir];
		int y1 = (y + dy[reverseDir]) + dy[clockDir];

		int x2 = (x + dx[reverseDir]) + dx[reverseClockDir];
		int y2 = (y + dy[reverseDir]) + dy[reverseClockDir];
		moveSand = (int) (sand * 0.01);

		spread(x, y, x1, y1, moveSand);
		spread(x, y, x2, y2, moveSand);

		// 7% 채우기
		x1 = x + dx[clockDir];
		y1 = y + dy[clockDir];

		x2 = x + dx[reverseClockDir];
		y2 = y + dy[reverseClockDir];

		moveSand = (int) (sand * 0.07);
		spread(x, y, x1, y1, moveSand);
		spread(x, y, x2, y2, moveSand);

		// 2% 채우기
		x1 = x + (dx[clockDir] * 2);
		y1 = y + (dy[clockDir] * 2);

		x2 = x + (dx[reverseClockDir] * 2);
		y2 = y + (dy[reverseClockDir] * 2);

		moveSand = (int) (sand * 0.02);
		spread(x, y, x1, y1, moveSand);
		spread(x, y, x2, y2, moveSand);

		// 10% 채우기
		x1 = (x + dx[dir]) + dx[clockDir];
		y1 = (y + dy[dir]) + dy[clockDir];

		x2 = (x + dx[dir]) + dx[reverseClockDir];
		y2 = (y + dy[dir]) + dy[reverseClockDir];

		moveSand = (int) (sand * 0.1);
		spread(x, y, x1, y1, moveSand);
		spread(x, y, x2, y2, moveSand);

		// 5% 채우기
		x1 = x + (dx[dir] * 2);
		y1 = y + (dy[dir] * 2);
		moveSand = (int) (sand * 0.05);

		spread(x, y, x1, y1, moveSand);

		// 남은 애들 채우기
		x1 = x + dx[dir];
		y1 = y + dy[dir];

		moveSand = arr[x][y];
		spread(x, y, x1, y1, moveSand);

	}

	private static void spread(int x, int y, int r, int c, int sand) {
		if (isOutRange(r, c)) {
			result += sand;
		} else {
			arr[r][c] += sand;
		}
		arr[x][y] -= sand;
	}

	private static boolean isOutRange(int i, int j) {
		return i < 0 || j < 0 || i >= N || j >= N ? true : false;
	}
}
