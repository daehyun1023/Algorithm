import java.util.*;
import java.io.*;

public class Swea1251하나로 {

	static class Pair implements Comparable<Pair> {
		int from;
		int to;
		double cost;

		Pair(int from, int to, double cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		@Override
		public int compareTo(Pair o) {
			// TODO Auto-generated method stub
			return (int) (this.cost - o.cost);
		}
	}

	static int N;
	static double E, result;
	static int[] X, Y;
	static double[] distance;
	static boolean[] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			X = new int[N];
			Y = new int[N];
			distance = new double[N];
			visited = new boolean[N];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(br.readLine());
			
			Arrays.fill(distance, Double.MAX_VALUE);
			distance[0] = 0;
			result = 0;
			for(int c=0; c<N; c++) {
				int current = 0;
				double min = Double.MAX_VALUE;
				for(int i=0; i<N; i++) {
					if(!visited[i] && min > distance[i]) {
						min = distance[i];
						current = i;
					}
				}
				
				visited[current] = true;
				result += min;
				
				for(int i=0; i<N; i++) {
					int x1 = X[current];
					int y1 = Y[current];
					int x2 = X[i];
					int y2 = Y[i];
					double cost = Math.pow(x1 - x2, 2) +  Math.pow(y1 - y2, 2);
					if(!visited[i] && distance[i] > cost) {
						distance[i] = cost;
					}
				}
				
			}
			System.out.println("#"+t+" "+Math.round(result*E));
			
		}
		
	}
}
