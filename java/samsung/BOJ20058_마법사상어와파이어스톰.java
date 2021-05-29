package samsung;

import java.util.*;
import java.io.*;

public class BOJ20058_마법사상어와파이어스톰 {

	static int n, Q, N, cnt, max = Integer.MIN_VALUE, area;
	static int[][] arr, temp;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());
		N = (int) Math.pow(2, n);
		arr = new int[N][N];
		check = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		st = new StringTokenizer(br.readLine());
		for (int t = 0; t < Q; t++) {
			int l = Integer.parseInt(st.nextToken());
			int L = (int) Math.pow(2, l);

			for (int i = 0; i < N; i += L) {
				for (int j = 0; j < N; j += L) {
					rotate(i, j, L);
				}
			}
			melt();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				cnt += arr[i][j];
				area = 0;
				if (!check[i][j] && arr[i][j] > 0) {
					dfs(i, j);
				}
				max = Math.max(max, area);
			}
		}
		System.out.println(cnt);
		System.out.println(max);
	}

	private static void dfs(int x, int y) {
		area++;
		check[x][y] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (isOutRange(nx, ny) || check[nx][ny] || arr[nx][ny] == 0)
				continue;
			dfs(nx, ny);
		}
	}

	private static void melt() {
		int[][] tempArr = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tempArr[i][j] = arr[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (tempArr[i][j] == 0)
					continue;
				int c = 0;
				for (int d = 0; d < 4; d++) {
					int nx = i + dx[d];
					int ny = j + dy[d];
					if (isOutRange(nx, ny) || tempArr[nx][ny] == 0)
						continue;
					c++;
				}
				if (c <= 2) {
					arr[i][j]--;
				}
			}
		}
	}

	private static boolean isOutRange(int nx, int ny) {
		return (nx < 0 || ny < 0 || nx >= N || ny >= N);
	}

	private static void rotate(int x, int y, int L) {
		temp = new int[L][L];
		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				temp[i][j] = arr[x + L - 1 - j][y + i];
			}
		}

		for (int i = 0; i < L; i++) {
			for (int j = 0; j < L; j++) {
				arr[x + i][y + j] = temp[i][j];
			}
		}
	}

}
