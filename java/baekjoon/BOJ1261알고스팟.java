import java.util.*;

public class BOJ1261알고스팟 {

	static class Pair {
		int x;
		int y;
		int z;

		Pair(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}

	static int M;
	static int N;
	static int[][] arr;
	static int[][] check;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static Queue<Pair> q = new LinkedList();
	static int result = Integer.MAX_VALUE;

	public static void bfs() {

		while (!q.isEmpty()) {
			Pair p = q.poll();

			if (p.x == N - 1 && p.y == M - 1) {
				result = Math.min(result, p.z);
			}

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (arr[nx][ny] == 0 && (check[nx][ny] == -1 || check[nx][ny] > p.z)) {
					check[nx][ny] = p.z;
					q.add(new Pair(nx, ny, p.z));
					continue;
				} else {
					if (check[nx][ny] > p.z + 1 || check[nx][ny] == -1) {
						check[nx][ny] = p.z + 1;
						q.add(new Pair(nx, ny, p.z + 1));
					}

				}

			}

		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		arr = new int[N][M];
		check = new int[N][M];
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - '0';
				check[i][j] = -1;
			}
		}
		check[0][0] = 0;
		q.add(new Pair(0, 0, 0));
		bfs();

		System.out.println(result);

	}

}
