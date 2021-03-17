import java.util.*;
import java.io.*;

public class BOJ16236아기상어 {

	static class Pair implements Comparable<Pair> {
		int x;
		int y;
		int d;

		Pair(int x, int y, int d) {
			this.x = x;
			this.y = y;
			this.d = d;
		}

		@Override
		public int compareTo(Pair o) {
			int diffD = this.d - o.d;
			if (diffD == 0) {
				int diffX = this.x - o.x;
				return diffX == 0 ? this.y - o.y : diffX;
			} else
				return diffD;
		}

	}

	static int N, t, feed, shark = 2;
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static PriorityQueue<Pair> pq = new PriorityQueue();

	public static boolean bfs() {
		while (!pq.isEmpty()) {
			Pair cur = pq.poll();
			if (arr[cur.x][cur.y] < shark && arr[cur.x][cur.y] > 0) {
				t += cur.d;
				feed++;
				if (feed == shark) {
					feed = 0;
					shark++;
				}
				pq.clear();
				pq.add(new Pair(cur.x, cur.y, 0));
				check = new boolean[N][N];
				arr[cur.x][cur.y] = 0;
				return true;
			}

			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] > shark || check[nx][ny])
					continue;
				check[nx][ny] = true;
				pq.add(new Pair(nx, ny, cur.d + 1));
			}
		}
		return false;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		check = new boolean[N][N];
		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 9) {
					arr[i][j] = 0;
					pq.add(new Pair(i, j, 0));
				}
			}
		}

		while (true) {
			if (!bfs()) {
				break;
			}
		}
		System.out.println(t);
	}

}
