import java.util.*;
import java.io.*;

public class swea5643키순서_DFS {

	static int N, M, cnt, adj[][], radj[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N + 1][N + 1];
			radj = new int[N + 1][N + 1];
			int i, j;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				radj[j][i] = adj[i][j] = 1; // i는 j보다 키가 작다.
			} // 친구 키 관계로 인접행렬 대입

			int ans = 0;

			for (int k = 1; k <= N; k++) {
				cnt = 0;
				dfs(k, adj,new boolean[N + 1]);
				dfs(k, radj,new boolean[N + 1]);
				if (cnt == N - 1)
					ans++;
			}
			System.out.println("#" + t + " " + ans);
		}
	}

	private static void dfs(int cur, int[][] adj, boolean[] visited) {
		visited[cur] = true;
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adj[cur][i] == 1) { //adj에 따라 자신보다 큰 학생을 탐색하거나 작은 학생을 탐색하는 의미
				dfs(i, adj, visited);
				cnt++;
			}
		}
	}
	
}
