import java.util.*;
import java.io.*;

public class BOJ2636치즈 {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, cnt, result, time;
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static Queue<Pair> q = new LinkedList();

	public static void bfs() {
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (arr[nx][ny] == 0 && !check[nx][ny]) {
					check[nx][ny] = true;
					q.add(new Pair(nx, ny));
				}
				if (arr[nx][ny] == 1) {
					check[nx][ny] = true;
					arr[nx][ny] = 0;
					cnt--;
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					cnt++;
			}
		}

		while (cnt > 0) {
			check = new boolean[N][M];
			q.add(new Pair(0, 0));
			result = cnt;
			time++;
			bfs();
		}

		System.out.println(time);
		System.out.println(result);

	}

}
