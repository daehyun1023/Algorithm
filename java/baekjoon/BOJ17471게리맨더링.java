package add;

import java.util.*;
import java.io.*;

public class BOJ17471게리맨더링 {

	static int N, total, min = Integer.MAX_VALUE, cnt;
	static int[] people, check;
	static ArrayList<Integer>[] edge;
	
	public static void combination(int depth, int mask, int start) {
		if(depth > N/2) return;
		if(depth >= 1 && depth <= N/2) {
			total = 0;
			cnt = 0;
			check = new int[N];
			boolean one = false;
			boolean two = false;
			for(int i=0; i<N; i++) {
				if(((1<<i) & mask) != 0 && !one) {
					one = true;
					total += people[i];
					dfs(i,1, mask);
				}
				else if (((1<<i) & mask) == 0 && !two){
					two = true;
					total -= people[i];
					dfs(i,2, mask);
				}
			}
			
			if(cnt != N) total = Integer.MAX_VALUE;
			min = Math.min(min, Math.abs(total));
			
		}
		
		for(int i=start; i<N; i++) {
			if(((1<<i) & mask) == 0) {
				combination(depth+1, mask | 1<<i, i);
			}
		}
	}
	
	private static void dfs(int x, int area, int mask) {
		check[x] = area;
		cnt++;
		for(int v : edge[x]) {
			if(area == 1 && check[v] == 0 && ((mask & 1<<v) != 0)) {
				total += people[v];
				dfs(v, area, mask);
			}
			else if(area == 2 && check[v] == 0 && ((mask & 1<<v) == 0)) {
				total -= people[v];
				dfs(v, area, mask);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		people = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		edge = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			people[i] = Integer.parseInt(st.nextToken());
			edge[i] = new ArrayList();
		}
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int x = Integer.parseInt(st.nextToken()) - 1;
				edge[i].add(x);
				edge[x].add(i);
			}
		}

		combination(0,0,0);
		System.out.println(min==Integer.MAX_VALUE ? -1 : min);
		
	}
}
