import java.util.*;
import java.io.*;

public class BOJ1167트리의지름 {

	static class Pair {
		int to;
		int dist;

		Pair(int to, int dist) {
			this.to = to;
			this.dist = dist;
		}
	}

	static int N;
	static ArrayList<Pair>[] arr;
	static int start;
	static Queue<Integer> q;
	static int[] check;

	public static void bfs(int x) {
		q = new LinkedList();
		q.add(x);
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (Pair p : arr[cur]) {
				if (check[p.to] == 0) {
					check[p.to] = p.dist + check[cur];
					q.add(p.to);
				}
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		arr = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			arr[i] = new ArrayList();
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			while (true) {
				int t = Integer.parseInt(st.nextToken());
				if (t == -1)
					break;
				int d = Integer.parseInt(st.nextToken());
				arr[x-1].add(new Pair(t - 1, d));
			}
		}

		check = new int[N];
		bfs(0);
		int max = 0;
		for (int i = 1; i < N; i++) {
			if (max < check[i]) {
				max = check[i];
				start = i;
			}
		}

		check = new int[N];
		bfs(start);
		max = 0;
		for (int i = 0; i < N; i++) {
			if (i == start)
				continue;
			max = Math.max(max, check[i]);
		}

		System.out.println(max);
	}

}
