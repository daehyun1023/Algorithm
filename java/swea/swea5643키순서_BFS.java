import java.util.*;
import java.io.*;

public class swea5643키순서_BFS {

	static int N, M, gtCnt, ltCnt, adj[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N + 1][N + 1];
			int i, j;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				i = Integer.parseInt(st.nextToken());
				j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1; // i는 j보다 키가 작다.
			} // 친구 키 관계로 인접행렬 대입

			int ans = 0;

			for (int k = 1; k <= N; k++) {
				gtCnt = ltCnt = 0;
				gtBFS(k, new boolean[N + 1]);
				ltBFS(k, new boolean[N + 1]);
				if (gtCnt + ltCnt == N - 1)
					ans++;
			}

			System.out.println("#" + t + " " + ans);
		}
	}

	private static void gtBFS(int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int k = q.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adj[k][i] == 1) {
					q.offer(i);
					visited[i] = true;
					gtCnt++;
				}
			}
		}
	}

	private static void ltBFS(int start, boolean[] visited) {
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(start);
		visited[start] = true;
		while (!q.isEmpty()) {
			int k = q.poll();
			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adj[i][k] == 1) {
					q.offer(i);
					visited[i] = true;
					ltCnt++;
				}
			}
		}
	}
}
