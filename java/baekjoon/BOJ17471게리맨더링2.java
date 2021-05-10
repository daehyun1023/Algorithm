package add;

import java.util.*;
import java.io.*;

public class BOJ17471게리맨더링2 {
	
	static int N, min;
	static int[][] matrix;
	static boolean[] select; // for subset
	static boolean[] visit; // for connection check

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		matrix = new int[N+1][N+1];
		select = new boolean[N+1];
		min = Integer.MAX_VALUE;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 1; j <= n; j++) {
				matrix[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
	}
	
	private static void subset(int depth) {
		// 기저조건
		if(depth == N + 1) {
			// complete code
			check();
			return;
		}
		
		select[depth] = true;
		subset(depth + 1);
		select[depth] = false;
		subset(depth + 1);
		
	}

	private static void check() {
		//visit 이용
		visit = new boolean[N+1];
		Queue<Integer> q = new LinkedList<Integer>();
		
		// A 
		for (int i = 1; i <= N; i++) {
			if(select[i]) {
				q.offer(i);
				break;
			}
		}
		
		if( q.size() == 0 || q.size() == N) return;
		
		while(!q.isEmpty()) {
			int n = q.poll();
			visit[n] = true;
			for (int i = 1; i <= N; i++) {
				int adj = matrix[n][i];
				if(adj == 0 || visit[adj] || !select[adj]) continue;
				q.offer(adj);
			}
		}
		
		// B
		for (int i = 1; i <= N; i++) {
			if(!select[i]) {
				q.offer(i);
				break;
			}
		}
		
		while(!q.isEmpty()) {
			int n = q.poll();
			visit[n] = true;
			for (int i = 1; i <= N; i++) {
				int adj = matrix[n][i];
				if(adj == 0 || visit[adj] || select[adj]) continue;
				q.offer(adj);
			}
		}
		
		boolean allVisit = true;
		for (int i = 1; i <= N; i++) {
			if(!visit[i]) {
				allVisit = false;
				break;
			}
		}
		
		if(allVisit) {
			int sumA = 0;
			int sumB = 0;
			for (int i = 1; i <= N; i++) {
				if(select[i]) sumA += matrix[i][0];			
				else sumB += matrix[i][0];
			}	
			min = Math.min(min, Math.abs(sumA - sumB));
		}
		
	}
	
}
