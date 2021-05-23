package add;

import java.util.*;
import java.io.*;

public class BOJ2933_미네랄 {

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int R, C, N;
	static char[][] arr;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static int[] heights;
	static Queue<Pair> q = new LinkedList<Pair>();
	static int[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][C];
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				arr[i][j] = str.charAt(j);
			}
		}

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int height = Integer.parseInt(st.nextToken());
			toss(R - height, i);
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
	}

	private static void toss(int height, int turn) {
		// 왼쪽에서 던지기
		if (turn % 2 == 0) {
			for (int i = 0; i < C; i++) {
				if (arr[height][i] == 'x') {
					arr[height][i] = '.';
					break;
				}
			}
		}
		// 오른쪽에서 던지기
		else {
			for (int i = C - 1; i >= 0; i--) {
				if (arr[height][i] == 'x') {
					arr[height][i] = '.';
					break;
				}
			}
		}
		// 지역 나누기
		findArea();
	}

	private static void findArea() {
		check = new int[R][C];
		int area = 0;
		for (int i = R - 1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if (arr[i][j] == 'x' && check[i][j] == 0) {
					check[i][j] = ++area;
					bfs(i, j, area);
				}
			}
		}
		
		// area인 높이들을 저장할 배열 구하기
		getHeights(area);
		// 다른클러스터와 최소 높이차이 구하기
		int minHeight = getMinHeight();
		fall(minHeight, area);

	}

	private static void fall(int minHeight, int area) {
		for (int i = R-1; i >= 0; i--) {
			for (int j = 0; j < C; j++) {
				if(check[i][j] == area) {
					arr[i][j] = '.';
					arr[i+minHeight-1][j] = 'x';
				}
			}
		}
	}

	private static void getHeights(int area) {
		heights = new int[C];
		Arrays.fill(heights, -1);
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (check[i][j] == area) {
					heights[j] = Math.max(heights[j], i);
				}
			}
		}
	}

	private static int getMinHeight() {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < C; i++) {
			if (heights[i] == -1)
				continue;
			int h = heights[i];
			while (true) {
				h++;
				if (h >= R || check[h][i] > 0)
					break;
			}
			min = Math.min(min, h - heights[i]);
		}
		return min;
	}

	private static void bfs(int i, int j, int area) {
		q.add(new Pair(i, j));
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				if (isOutRange(nx, ny) || check[nx][ny] != 0)
					continue;
				if(arr[nx][ny] == 'x' && check[nx][ny] == 0) {					
					check[nx][ny] = area;
					q.add(new Pair(nx, ny));
				}
			}
		}
	}

	private static boolean isOutRange(int x, int y) {
		return (x < 0 || y < 0 || x >= R || y >= C);
	}

}
