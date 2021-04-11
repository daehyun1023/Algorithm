import java.util.*;
import java.io.*;
public class Swea3289서로소집합 {

	static int n, m;
	static int[] parents;
	
	static void make() {
		for(int i=1; i<=n; i++) {
			parents[i] = i;
		}
	}
	
	static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		if( aRoot == bRoot ) {
			return false;
		}
		parents[bRoot] = aRoot;
		return true;
		
	}
	
	static int find(int a) {
		if(parents[a] == a) {
			return a;
		}
		return parents[a] = find(parents[a]);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb;
		StringTokenizer st;
		for(int t=1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			parents = new int[n+1];
			make();
			sb = new StringBuilder();
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				int op = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(op == 0) {
					union(a,b);
				}
				else {
					if(find(a) == find(b)) {
						sb.append(1);
					}
					else {
						sb.append(0);
					}
				}
			}
			System.out.println("#"+t+" "+sb);
		}
	}

}
