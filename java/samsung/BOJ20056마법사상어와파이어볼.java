package samsung;

import java.util.*;
import java.io.*;

public class BOJ20056마법사상어와파이어볼 {

	static class Ball {
		int x;
		int y;
		int m;
		int s;
		int d;

		Ball(int x, int y, int m, int s, int d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}

	static class Info {
		int m;
		int s;
		int d;
		int c;
		int even;
		int odd;

		Info(int m, int s, int d, int c, int even, int odd) {
			this.m = m;
			this.s = s;
			this.d = d;
			this.c = c;
			this.even = even;
			this.odd = odd;
		}
	}

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int N, M, K, result = 0;
	static Info[][] arr;
	static Queue<Ball> q = new LinkedList<Ball>();

	public static void moveBall() {
		while (!q.isEmpty()) {
			Ball ball = q.poll();
			int nx = (ball.x + (dx[ball.d] * (ball.s % N)));
			int ny = (ball.y + (dy[ball.d] * (ball.s % N)));
			if (nx >= N) {
				nx -= N;
			} else if (nx < 0) {
				nx += N;
			}
			if (ny >= N) {
				ny -= N;
			} else if (ny < 0) {
				ny += N;
			}

			if (arr[nx][ny] == null) {
				if (ball.d % 2 == 0) {
					arr[nx][ny] = new Info(ball.m, ball.s, ball.d, 1, 1, 0);
				} else {
					arr[nx][ny] = new Info(ball.m, ball.s, ball.d, 1, 0, 1);
				}

			} else {
				arr[nx][ny].c += 1;
				arr[nx][ny].m += ball.m;
				arr[nx][ny].s += ball.s;
				if (ball.d % 2 == 0) {
					arr[nx][ny].even += 1;
				} else {
					arr[nx][ny].odd += 1;
				}

				arr[nx][ny].d += ball.d;
			}
		}
	}

	public static void sumBall() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == null)
					continue;
				if (arr[i][j].c == 1) {
					q.add(new Ball(i, j, arr[i][j].m, arr[i][j].s, arr[i][j].d));
				} else {
					arr[i][j].m /= 5;
					if (arr[i][j].m == 0) {
						continue;
					}
					arr[i][j].s /= arr[i][j].c;
					if (arr[i][j].even == 0 || arr[i][j].odd == 0) {
						for (int k = 0; k < 4; k++) {
							q.add(new Ball(i, j, arr[i][j].m, arr[i][j].s, k * 2));
						}
					} else {
						for (int k = 0; k < 4; k++) {
							q.add(new Ball(i, j, arr[i][j].m, arr[i][j].s, (k * 2) + 1));
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			q.offer(new Ball(x, y, m, s, d));
		}

		for (int i = 0; i < K; i++) {
			arr = new Info[N][N];
			moveBall();
			sumBall();
		}

		while (!q.isEmpty()) {
			Ball ball = q.poll();
			result += ball.m;
		}
		System.out.println(result);
	}

}
