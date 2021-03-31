import java.util.*;
import java.io.*;

public class BOJ14502연구소 {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, max, result = Integer.MIN_VALUE;
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static Queue<Pair> q = new LinkedList<Pair>();;
	static ArrayList<Pair> empty = new ArrayList<Pair>();
	static ArrayList<Pair> virus = new ArrayList<Pair>();

	public static void combination(int depth, int start) {
		if (depth == 3) {
			max = empty.size();
			check = new boolean[N][M];
			for (Pair p : virus) {
				q.add(new Pair(p.x, p.y));
				check[p.x][p.y] = true;
			}

			bfs();
			result = Math.max(result, max);
			return;

		}

		for (int i = start, size = empty.size(); i < size; i++) {
			if (arr[empty.get(i).x][empty.get(i).y] == 0) {
				arr[empty.get(i).x][empty.get(i).y] = 1;
				combination(depth + 1, i);
				arr[empty.get(i).x][empty.get(i).y] = 0;
			}
		}
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 1 || check[nx][ny])
					continue;
				check[nx][ny] = true;
				max--;
				q.add(new Pair(nx, ny));
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
				if (arr[i][j] == 0) {
					empty.add(new Pair(i, j));
				}
				if (arr[i][j] == 2) {
					virus.add(new Pair(i, j));
				}
			}
		}
		combination(0, 0);
		System.out.println(result - 3);

	}

}
