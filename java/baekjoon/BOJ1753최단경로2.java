import java.io.*;
import java.util.*;

public class BOJ1753최단경로2 {

	static int V, E, K, min;
	static ArrayList<ArrayList<Pair>> list = new ArrayList<ArrayList<Pair>>();
	static int[] cost;
	static boolean[] visited;
	static PriorityQueue<Pair> pq = new PriorityQueue<Pair>((e1, e2) -> e1.c - e2.c);

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		visited = new boolean[V + 1];
		cost = new int[V + 1];

		for (int i = 0; i <= V; i++) {
			cost[i] = Integer.MAX_VALUE;
			list.add(new ArrayList<Pair>());
		}

		for (int i = 1; i <= E; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list.get(v1).add(new Pair(v2, w));
		}
		
		dijkstra();
		
	}

	static void dijkstra() {
		cost[K] = 0;
		pq.offer(new Pair(K,0));
		while(!pq.isEmpty()) {
			Pair cur = pq.poll();
			
			//visit
			if( visited[cur.v] ) continue;
			visited[cur.v] = true;
			
			for(Pair np : list.get(cur.v)) {
				if( cost[cur.v] + np.c < cost[np.v] ) {
					cost[np.v] = cost[cur.v] + np.c;
					np.c = cost[np.v];
					pq.offer(np);
				}
			}
		}
	}
	
	static class Pair {
		int v, c;

		Pair(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}

}
