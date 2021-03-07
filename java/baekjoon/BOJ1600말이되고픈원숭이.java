import java.util.*;
import java.io.*;
import java.nio.Buffer;

public class BOJ1600말이되고픈원숭이 {

	static class Pair {
		int x;
		int y;
		int cnt;

		Pair(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}

	static int K, M, N, result = -1;
	static int[][] arr;
	static int[][][] check;
	static int[] dx = { -1, 0, 0, 1, -2, -2, -1, -1, 1, 1, 2, 2 };
	static int[] dy = { 0, -1, 1, 0, -1, 1, -2, 2, -2, 2, -1, 1 };
	static Queue<Pair> q = new LinkedList();

	public static void bfs() {
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			if (curr.x == N - 1 && curr.y == M - 1) {
				result = check[curr.x][curr.y][curr.cnt];
				return;
			}

			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || check[nx][ny][curr.cnt] != 0 || arr[nx][ny] == 1)
					continue;
				check[nx][ny][curr.cnt] = check[curr.x][curr.y][curr.cnt] + 1;
				q.add(new Pair(nx, ny, curr.cnt));
			}

			if (curr.cnt >= K)
				continue;
			for (int i = 4; i < 12; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || check[nx][ny][curr.cnt + 1] != 0 || arr[nx][ny] == 1)
					continue;
				check[nx][ny][curr.cnt + 1] = check[curr.x][curr.y][curr.cnt] + 1;
				q.add(new Pair(nx, ny, curr.cnt + 1));
			}

		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		check = new int[N][M][K + 1];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		q.add(new Pair(0, 0, 0));
		bfs();
		System.out.println(result);
	}

}
