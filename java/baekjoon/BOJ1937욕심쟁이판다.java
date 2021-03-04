import java.io.*;
import java.util.*;

public class Main {
	public static int N, ans;
	public static int[][] map;
	public static int[][] v;
	public static int[] dx = { -1, 1, 0, 0 };
	public static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		v = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (v[i][j] == 0)
					dfs(i, j);
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(v[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println(ans);
	}

	public static void dfs(int x, int y) {
		int cnt = 0;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N)
				continue;
			if (map[nx][ny] > map[x][y]) {
				if (v[nx][ny] == 0)
					dfs(nx, ny);

				if (cnt < v[nx][ny])
					cnt = v[nx][ny];
			}
		}
		v[x][y] = cnt + 1;
		ans = Math.max(ans, v[x][y]);
	}
}