package add;

import java.util.*;

import add.BOJ2580스도쿠.Pair;

import java.io.*;

public class BOJ2580스도쿠2 {

	static class Pair {
		int x, y;
		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static boolean complete = false;
	static int[][] map;
	static ArrayList<Pair> zero;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		zero = new ArrayList<Pair>();
		map = new int[9][9];
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 0) {
					zero.add(new Pair(i, j));
				}
			}
		}
		dfs(0);
	}

	private static void dfs(int idx) {
		// 기저조건
		if (complete)
			return;

		if (idx == zero.size()) {
			complete = true;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.println(map[i][j] + " ");
				}
				System.out.println();
			}
			return;
		}

		// idx 하나씩 꺼내서
		int x = zero.get(idx).x;
		int y = zero.get(idx).y;

		boolean visitRow[] = new boolean[10];
		boolean visitCol[] = new boolean[10];
		boolean visitRect[] = new boolean[10];

		// 가로, 세로
		for (int i = 0; i < 9; i++) {
			if (map[x][i] != 0)
				visitRow[map[x][i]] = true;
			if (map[i][y] != 0)
				visitRow[map[i][y]] = true;
		}

		int nx = (x / 3) * 3;
		int ny = (y / 3) * 3;
		for (int i = nx; i < nx + 3; i++) {
			for (int j = ny; j < ny + 3; j++) {
				if (map[i][j] != 0)
					visitRect[map[i][j]] = true;
			}
		}

		// 1~9 숫자 중에 사용할 수 있는 (이미 사용된 숫자가 아닌 경우)
		for (int i = 1; i <= 9; i++) {
			if (visitRow[i] || visitCol[i] || visitRect[i])
				continue;
			map[x][y] = i;
			dfs(idx + 1);
			map[x][y] = 0;
		}
	}
}
