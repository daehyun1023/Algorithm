import java.util.*;
import java.io.*;

public class BOJ10282해킹 {

	static class Pair {
		int v;
		int cost;

		Pair(int v, int cost) {
			this.v = v;
			this.cost = cost;
		}
	}

	static int T, N, D, C, INF;
	static ArrayList<Pair>[] A;
	static boolean[] visited;
	static int[] distance;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			D = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken()) - 1;
			INF = Integer.MAX_VALUE;
			A = new ArrayList[N];
			visited = new boolean[N];
			distance = new int[N];

			for (int i = 0; i < N; i++) {
				A[i] = new ArrayList();
			}

			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				int s = Integer.parseInt(st.nextToken());
				A[b].add(new Pair(a, s));
			}

			Arrays.fill(distance, INF);

			distance[C] = 0;
//		PriorityQueue<Pair> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);

			while (true) {
				int min = INF;
				int idx = 0;
				for (int i = 0; i < N; i++) {
					if (!visited[i] && min > distance[i]) {
						min = distance[i];
						idx = i;
					}
				}

				visited[idx] = true;
				if (min == INF)
					break;

				for (Pair p : A[idx]) {
					if (p.cost + min < distance[p.v]) {
						distance[p.v] = p.cost + distance[idx];
					}
				}
			}
			int max = 0;
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				if (distance[i] == INF)
					continue;
				cnt++;
				if (max < distance[i]) {
					max = distance[i];
				}
			}

			System.out.println(cnt + " " + max);
		}
	}

}
