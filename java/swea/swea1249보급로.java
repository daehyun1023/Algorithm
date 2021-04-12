import java.util.*;
import java.io.*;

public class swea1249보급로 {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int N, min;
	static int[][] arr, ans;
	static boolean[][] visited;

	public static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		visited[x][y] = true;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			if (p.x == N - 1 && p.y == N - 1) {
				min = min > ans[N - 1][N - 1] ? ans[N - 1][N - 1] : min;
			}

			if (min <= ans[p.x][p.y])
				continue;

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				if (visited[nx][ny] == false || ans[nx][ny] > ans[p.x][p.y] + arr[nx][ny]) {
					visited[nx][ny] = true;
					ans[nx][ny] = ans[p.x][p.y] + arr[nx][ny];
					q.add(new Pair(nx, ny));
				}
			}

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		min = Integer.MAX_VALUE;
		visited = new boolean[N][N];
		ans = new int[N][N];

		for (int i = 0; i < N; i++) {
			Arrays.fill(arr[i], Integer.MAX_VALUE);
		}

		ans[0][0] = 0;
		bfs(0, 0);
		System.out.println(min);

	}

}
