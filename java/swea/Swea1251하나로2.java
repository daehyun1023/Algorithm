import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//dfs로 거리가 짧은 순으로 넣기 시작해서 하나로 연결된 집합안에 있는 섬 중에 자기 자신과 가장 거리가 짧은 섬과 연결 시켜가며 처음으로 전체 연결된 곳이 있다면 계산
public class Swea1251하나로2 {
	static int T, N;
	static long[][] matrix;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		StringTokenizer st, st2;
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			int x[] = new int[N];
			int y[] = new int[N];
			matrix = new long[N][N];
			st = new StringTokenizer(br.readLine(), " ");
			st2 = new StringTokenizer(br.readLine(), " ");
			for (int i = 0; i < x.length; i++) {
				x[i] = Integer.parseInt(st.nextToken());
			}
			for (int i = 0; i < y.length; i++) {
				y[i] = Integer.parseInt(st2.nextToken());
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					matrix[i][j] = matrix[j][i] = distance(x[i], x[j], y[i], y[j]);
				}
			}
			double E = Double.parseDouble(br.readLine());
			System.out.println("#" + t + " " + Math.round(makeMST() * E));
		}

	}

	private static double makeMST() {

		long[] minEdge = new long[N];
		boolean[] visited = new boolean[N];

		Arrays.fill(minEdge, Long.MAX_VALUE);
		minEdge[0] = 0;

		PriorityQueue<Vertex> queue = new PriorityQueue<>();
		queue.offer(new Vertex(0, minEdge[0]));

		long result = 0;
		int cnt = 0;

		while (true) {
			Vertex minVertex = queue.poll();
			if (visited[minVertex.no])
				continue;
			visited[minVertex.no] = true;
			result += minVertex.cost;
			if (++cnt == N)
				break;

			for (int i = 0; i < N; i++) {
				if (!visited[i] && minEdge[i] > matrix[minVertex.no][i]) {
					minEdge[i] = matrix[minVertex.no][i];
					queue.offer(new Vertex(i, minEdge[i]));
				}
			}
		}
		return result;
	}

	private static long distance(int x1, int x2, int y1, int y2) {
		return (long) (Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
	}

	static class Vertex implements Comparable<Vertex> {
		int no;
		long cost;

		public Vertex(int no, long cost) {
			super();
			this.no = no;
			this.cost = cost;
		}

		@Override
		public int compareTo(Vertex o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}
	}

}