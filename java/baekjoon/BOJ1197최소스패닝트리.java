import java.util.*;
import java.io.*;
public class BOJ1197최소스패닝트리 {

	static class Edge implements Comparable<Edge>{
		int from;
		int to;
		int weight;
		Edge(int from, int to, int weight){
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
		@Override
		public int compareTo(Edge o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}
	}
	
	static int V, E, min = 0;
	static Edge[] edgeArray;
	static int[] parents;
	
	public static void make() {
		for(int i=0; i<V; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int x) {
		if(parents[x] == x) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
	
	public static boolean union(int x, int y) {
		int xRoot = find(x);
		int yRoot = find(y);
		if(xRoot == yRoot) {
			return false;
		}
		
		parents[yRoot] = xRoot;
		return true;
		
	}
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		edgeArray = new Edge[E];
		parents = new int[V];
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edgeArray[i] = new Edge(from-1 , to-1, weight);
		}
		
		Arrays.sort(edgeArray);
		make();
		int cnt = 0;
		
		for(Edge edge: edgeArray) {
			if(union(edge.from, edge.to)) {
				min += edge.weight;
				if(++cnt == V-1) {
					break;
				}
			}
		}
		
		System.out.println(min);
		
	}

}
