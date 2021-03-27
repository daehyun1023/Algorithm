import java.util.*;
import java.io.*;

public class BOJ17472다리만들기2 {

	static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int dist;

		Edge(int from, int to, int dist) {
			this.from = from;
			this.to = to;
			this.dist = dist;
		}

		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.dist - o.dist;
		}
	}

	static class Pair {
		int x;
		int y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int N, M, result, d;
	static int[][] arr;
	static boolean[][] check;
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };
	static Queue<Pair> q;
	static ArrayList<ArrayList<Pair>> areaList = new ArrayList();
	static ArrayList<Edge> edgeList = new ArrayList();
	static ArrayList<Pair> before;
	static ArrayList<Pair> after;
	static int[] parents;
	static int size;
	
	public static void bfs(int x, int y, int area) {
		q = new LinkedList();
		areaList.add(new ArrayList());
		areaList.get(area - 1).add(new Pair(x, y));
		q.add(new Pair(x, y));
		check[x][y] = true;
		arr[x][y] = area;
		while (!q.isEmpty()) {
			Pair p = q.poll();
			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || check[nx][ny] || arr[nx][ny] == 0) {
					continue;
				}
				check[nx][ny] = true;
				arr[nx][ny] = area;
				q.add(new Pair(nx, ny));
				areaList.get(area - 1).add(new Pair(nx, ny));
			}
		}
	}

	public static int isValid(int x1, int y1, int x2, int y2, int dir, int from, int to) {
		int nx = x1;
		int ny = y1;
		d = 0;
		while (true) {
			d++;
			nx += dx[dir];
			ny += dy[dir];
			if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == from || (arr[nx][ny] !=0 && arr[nx][ny] != to))
				return 0;
			if (arr[nx][ny] == to) {
				return d;
			}
		}
	}

	public static void getEdgeLength(int from, int to) {
		int min = Integer.MAX_VALUE;
		for (Pair b : before) {
			for (Pair a : after) {
				for (int i = 0; i < 4; i++) {
					if (isValid(b.x, b.y, a.x, a.y, i, from+1, to+1) >= 3) {
						min = Math.min(min, d-1);
					}
				}
			}
		}
		edgeList.add(new Edge(from, to, min));
	}

	public static void kruskal() {
		make();
		Collections.sort(edgeList);
		result = 0;
		int cnt = 0;

		for (Edge edge : edgeList) {
			if (union(edge.from, edge.to)) {
				if(edge.dist == Integer.MAX_VALUE) {
					result = -1;
					break;
				}
				result += edge.dist;
				if (++cnt == size - 1) {
					break;
				}
			}
		}

	}

	public static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if (rootX == rootY)
			return false;
		parents[rootY] = rootX;
		return true;
	}

	public static void make() {
		parents = new int[size];
		for (int i = 0; i < size; i++) {
			parents[i] = i;
		}
	}

	public static int find(int x) {
		if (parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		check = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int area = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 1 && check[i][j] == false) {
					bfs(i, j, ++area);
				}
			}
		}
		
		size = area;
		for (int i = 0; i < size; i++) {
			for (int j = i + 1; j < size; j++) {
				before = areaList.get(i);
				after = areaList.get(j);
				getEdgeLength(i, j);
			}
		}

		// 크루스칼 적용
		kruskal();
		System.out.println(result);
	}

}
