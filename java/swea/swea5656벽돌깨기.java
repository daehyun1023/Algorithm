import java.util.*;
import java.io.*;

public class swea5656벽돌깨기 {

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, W, H, result;
	static int[][] arr, temp;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int[] numbers;
	static Queue<Pair> q;
	static boolean[][] visited;

	public static void permutation(int depth) {
		if (depth == N) {
			int cnt = 0;
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					temp[i][j] = arr[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				simulation(numbers[i]);
			}

			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (temp[i][j] != 0) {
						cnt++;
					}
				}
			}
			result = Math.min(result, cnt);
			return;
		}

		for (int i = 0; i < W; i++) {
			numbers[depth] = i;
			permutation(depth + 1);
		}

	}

	private static void simulation(int number) {
		q = new LinkedList<Pair>();
		for (int i = 0; i < H; i++) {
			if (temp[i][number] != 0) {
				q.add(new Pair(i, number));
				break;
			}
		}
		visited = new boolean[H][W];
		bfs();
		fall();
	}

	private static void fall() {
		for (int i = H - 1; i >= 1; i--) {
			for (int j = 0; j < W; j++) {
				if (temp[i][j] == 0) {
					int k = i;
					while (k >= 0 && temp[k][j] == 0) {
						k--;
					}
					if (k >= 0) {
						temp[i][j] = temp[k][j];
						temp[k][j] = 0;
					}
				}
			}
		}
	}

	public static void bfs() {
		while (!q.isEmpty()) {
			Pair p = q.poll();
			int power = temp[p.x][p.y];
			temp[p.x][p.y] = 0;
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j < power; j++) {
					int nx = p.x + (dx[i] * j);
					int ny = p.y + (dy[i] * j);
					if (isOutRange(nx, ny) || temp[nx][ny] == 0 || visited[nx][ny])
						continue;
					visited[nx][ny] = true;
					q.add(new Pair(nx, ny));
				}
			}
		}
	}

	private static boolean isOutRange(int x, int y) {
		return (x < 0 || y < 0 || x >= H || y >= W) ? true : false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			result = Integer.MAX_VALUE;
			arr = new int[H][W];
			temp = new int[H][W];
			numbers = new int[N];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			System.out.println("#"+t+" " +result);
		}
	}
}
