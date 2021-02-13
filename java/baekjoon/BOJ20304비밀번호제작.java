import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ20304비밀번호제작 {

	static int N;
	static int M;
	static int[] pwd;
	static Queue<Integer> q = new LinkedList();
	static int[] visit;
	static int max = Integer.MIN_VALUE;

	public static void bfs() {
		while (!q.isEmpty()) {
			int x = q.poll();
			for (int temp = 1; temp <= N; temp <<= 1) {
				int newX = temp ^ x;
				if (newX > N)
					continue;
				if (visit[newX] == -1) {
					visit[newX] = visit[x] + 1;
					q.add(newX);
					max = Math.max(max, visit[newX]);
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		pwd = new int[M];
		visit = new int[N + 1];
		for (int i = 0; i <= N; i++) {
			visit[i] = -1;
		}

		for (int i = 0; i < M; i++) {
			pwd[i] = Integer.parseInt(st.nextToken());
			q.add(pwd[i]);
			visit[pwd[i]] = 0;
		}

		bfs();
		System.out.println(max);

	}
}