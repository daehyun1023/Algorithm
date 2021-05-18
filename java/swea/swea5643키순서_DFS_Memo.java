import java.util.*;
import java.io.*;

public class swea5643키순서_DFS_Memo {

	static int N, M, cnt, adj[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			M = Integer.parseInt(br.readLine());
			adj = new int[N + 1][N + 1];
			
			for (int i = 0; i < N+1; i++) { // 자신보다 큰 학생을 아직 탐색하지 않은 상태의 초기값
				adj[i][0] = -1;
			}
			
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(br.readLine());
				int i = Integer.parseInt(st.nextToken());
				int j = Integer.parseInt(st.nextToken());
				adj[i][j] = 1; // i는 j보다 키가 작다.
			} // 친구 키 관계로 인접행렬 대입

			int ans = 0;

			for (int k = 1; k <= N; k++) {
				if(adj[k][0] == -1) {					
					dfs(k); // 메모의 상태를 보고 아직 탐색 전이면 자신보다 큰 학생 쭉 따라 탐색
				}
			}
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adj[0][j] += adj[i][j];
				}
			} // 자신보다 작은 학생의 수 카운팅
			
			for (int k = 1; k <= N; k++) {
				if(adj[k][0] + adj[0][k] == N-1) {
					ans++;
				}
			}

			System.out.println("#" + t + " " + ans);
		}
	}

	private static void dfs(int cur) {
		for (int i = 1; i <= N; i++) {
			if(adj[cur][i] == 1) {
				
				if(adj[i][0] == -1) dfs(i); // 아직 탐색하지 않은 학생이면 탐색하러 가기
				
				// i학생을 탐색하고 왔거나, 이미 탐색이 되어있어서 탐색하지 않고 내려옴.
				if(adj[i][0] > 0) { // i 학생보다 큰 학생이 있다면
					for (int j = 1; j <= N; j++) {
						if(adj[i][j] == 1) adj[cur][j] = 1;
					}
				}	
			}
		}
		
		int cnt = 0;
		for (int i = 1; i <= N; i++) {
			cnt += adj[cur][i];
		}
		adj[cur][0] = cnt;
		
	}

}
