import java.util.*;
import java.io.*;

public class BOJ17135캐슬디펜스 {

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
			int diff = this.d - o.d;
			return (diff != 0) ? diff : this.y - o.y;
		}
	}

	static int N, M, D, enemyCnt, tempCnt, row;
	static int[][] arr, temp;
	static PriorityQueue<Pair> q = new PriorityQueue();
	static int[] archer = new int[3];
	static int[] dx = { -1, 0, 0 };
	static int[] dy = { 0, -1, 1 };
	static boolean[][] check;
	static ArrayList<Pair> enemy;
	static int result = Integer.MIN_VALUE;
	static int cnt;

	public static void bfs() {
		while (!q.isEmpty()) {
			Pair curr = q.poll();
			if (temp[curr.x][curr.y] == 1) {
				if (curr.d <= D) {
					enemy.add(new Pair(curr.x, curr.y, 0));
				}
				break;
			}

			for (int i = 0; i < 3; i++) {
				int nx = curr.x + dx[i];
				int ny = curr.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= row || ny >= M)
					continue;
				if (check[nx][ny] == false) {
					check[nx][ny] = true;
					q.add(new Pair(nx, ny, curr.d + 1));
				}
			}
		}
	}

	public static void combination(int depth, int mask, int start) {
		if (depth == 3) {
			// 죽인 적의 수
			cnt = 0;
			// arr 배열 복사, 계속 temp 배열로 값을 변경해줌
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					temp[i][j] = arr[i][j];
				}
			}

			// 모든 적의 수 값 복사
			tempCnt = enemyCnt;
			// 적을 움직이지 않고 궁수를 움직일 것이므로 row를 계속 바꿔줄 것임
			row = N;
			// 모든 적의 수가 0이되면 게임 종료
			while (tempCnt > 0) {
				// 죽이는 적들에 대한 위치정보 넣어주기 위함
				enemy = new ArrayList();
				for (int i = 0; i < 3; i++) {
					// 방문 배열 초기화
					check = new boolean[N][M];
					q.clear();
					q.add(new Pair(row, archer[i], 0));
					// bfs돌리면서 죽일 적의 위치 넣어주기
					bfs();
				}
				// bfs 이후 enemy에 있는 적들을 죽여줌
				for (Pair p : enemy) {
					if (temp[p.x][p.y] == 1) {
						temp[p.x][p.y] = 0;
						cnt++;
						tempCnt--;
					}
				}

				// 궁수 한칸씩 앞으로 이동
				row -= 1;
				// 궁수랑 같은 행에 있는 애들 죽여줌
				for (int i = 0; i < M; i++) {
					if (temp[row][i] == 1) {
						tempCnt--;
					}
				}
			}
			result = Math.max(result, cnt);
			return;
		}

		for (int i = start; i < M; i++) {
			if ((mask & 1 << i) != 0)
				continue;
			archer[depth] = i;
			combination(depth + 1, mask | 1 << i, i);
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N + 1][M];
		temp = new int[N + 1][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 1)
					enemyCnt++;
			}
		}

		combination(0, 0, 0);

		System.out.println(result);

	}

}
