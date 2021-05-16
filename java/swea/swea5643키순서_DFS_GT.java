import java.util.*;
import java.io.*;

public class swea5643키순서_DFS_GT {

	static int N, M, cnt, adj[][];
	static int[] gtCnt, ltCnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N + 1][N + 1];
			gtCnt = new int[N + 1];
			ltCnt = new int[N + 1];
			int i, j;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1; // i는 j보다 키가 작다.
			} // 친구 키 관계로 인접행렬 대입

			int ans = 0;

			for (int k = 1; k <= N; k++) {
				dfs(k, k, new boolean[N + 1]);
			}
			for (int k = 1; k <= N; k++) {
				if (gtCnt[k] + ltCnt[k] == N - 1)
					ans++;
			}

			System.out.println("#" + t + " " + ans);
		}
	}

	private static void dfs(int cur, int start, boolean[] visited) {
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adj[cur][i] == 1) { // adj에 따라 자신보다 큰 학생을 탐색하거나 작은 학생을 탐색하는 의미
				dfs(i, start, visited);
				gtCnt[start]++;
				ltCnt[i]++;
			}
		}
	}

}
