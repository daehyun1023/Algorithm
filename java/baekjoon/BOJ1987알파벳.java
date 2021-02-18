import java.util.*;
import java.io.*;

public class BOJ1987알파벳 {

	static int N, M, max;
	static int[][] arr;
	static boolean[] containChar;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void dfs(int x, int y, int d) {
		containChar[arr[x][y]] = true;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M)
				continue;
			if (containChar[arr[nx][ny]] == true)
				continue;
			dfs(nx, ny, d + 1);
		}
		containChar[arr[x][y]] = false;
		max = Math.max(max, d);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		containChar = new boolean[26];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				arr[i][j] = str.charAt(j) - 'A';
			}
		}

		dfs(0, 0, 1);
		System.out.println(max);
	}

}
