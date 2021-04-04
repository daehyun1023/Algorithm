import java.util.*;
import java.io.*;
public class BOJ1520내리막길 {

	static int N, M;
	static int[][] arr, dp;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static boolean isInRange(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < M;
	}

	public static int dfs(int x, int y) {
		if (x == N - 1 && y == M - 1) {
			return 1;
		}
		
		if(dp[x][y] == -1) {
			dp[x][y]++;
			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if (isInRange(nx, ny) && arr[nx][ny] < arr[x][y]) {
					dp[x][y] += dfs(nx, ny);
				}		
			}
		}

		return dp[x][y];
		
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		System.out.println(dfs(0, 0));
	}

}
