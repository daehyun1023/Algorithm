import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class swea1868파핑파핑지뢰찾기 {

	static int T, N, ans;
	static char[][] map;
	static boolean[][] visit;
	static int[] dy = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dx = { -1, 0, 1, -1, 1, -1, 0, 1 };
	static Queue<Point> queue = new LinkedList<Point>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());

			map = new char[N][N];
			visit = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				map[i] = br.readLine().toCharArray();
			}

			// 풀이
			ans = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] != '.')
						continue;

					// . 주변의 * (지뢰) 수 확인
					int mine = 0;
					for (int k = 0; k < 8; k++) {
						int ny = i + dy[k];
						int nx = j + dx[k];

						if (ny < 0 || nx < 0 || ny >= N || nx >= N)
							continue;
						if (map[ny][nx] == '*')
							mine++;
					}

					if (mine == 0) {

						ans++;
						queue.offer(new Point(i, j));
						bfs();
					}
				}
			}

			// map . 수를 추가로 계산

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == '.')
						ans++;
				}
			}

			System.out.println("#" + t + " " + ans);
		}

	}

	static void bfs() {

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			int y = p.y;
			int x = p.x;

			int mine = 0;
			for (int k = 0; k < 8; k++) {
				int ny = y + dy[k];
				int nx = x + dx[k];

				if (ny < 0 || nx < 0 || ny >= N || nx >= N)
					continue;
				if (map[ny][nx] == '*') {
					mine++;
					break;
				}
			}

			map[y][x] = '^'; // . -> ^

			if (mine == 0) {
				for (int k = 0; k < 8; k++) {
					int ny = y + dy[k];
					int nx = x + dx[k];

					if (ny < 0 || nx < 0 || ny >= N || nx >= N)
						continue;
					if (map[ny][nx] != '.' || visit[ny][nx])
						continue;

					visit[ny][nx] = true;
					queue.offer(new Point(ny, nx));
				}
			}
		}
	}

	static class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
