import java.io.*;
import java.util.*;

public class BOJ1753최단경로 {

	static class Pair {
		int c;
		int w;

		Pair(int c, int w) {
			this.c = c;
			this.w = w;
		}
	}

	static int V, E, start;
	static boolean[] visited;
	static int[] distance;
	static PriorityQueue<Pair> pq;
	static ArrayList<Pair>[] adjList;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine()) - 1;
		pq = new PriorityQueue();
		visited = new boolean[V];
		distance = new int[V];
		adjList = new ArrayList[V];
		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<Pair>();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int w = Integer.parseInt(st.nextToken());
			adjList[x].add(new Pair(y, w));
		}

		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[start] = 0;

		for (int c = 0; c < V; c++) {
			int min = Integer.MAX_VALUE;
			int current = 0;

			for (int i = 0; i < V; i++) {
				if (!visited[i] && min > distance[i]) {
					min = distance[i];
					current = i;
				}
			}

			visited[current] = true;
			for (Pair edge : adjList[current]) {
				if(!visited[edge.c] && distance[edge.c] > min + edge.w ) {
					distance[edge.c] = min + edge.w;
				}
			}
			
		}
		
		for(int i=0; i<V; i++) {
			if(distance[i]==Integer.MAX_VALUE) {
				System.out.println("INF");
				continue;
			}
			System.out.println(distance[i]);
		}
		
	}

}
