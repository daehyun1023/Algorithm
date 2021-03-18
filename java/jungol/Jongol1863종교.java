package hwalgo17_서울_13반_안대현;
import java.util.*;
import java.io.*;
public class Jongol1863종교 {
	
	static int n, m;
	static int[] parents;
	
	public static void make() {
		for(int i=0; i<n; i++) {
			parents[i] = i;
		}
	}
	
	public static int find(int x) {
		if(x == parents[x]) {
			return x;
		}
		return parents[x] = find(parents[x]);
	}
	
	public static boolean union(int x, int y) {
		int rootX = find(x);
		int rootY = find(y);
		if(rootX == rootY) {
			return true;
		}
		parents[rootY] = rootX;
		return false;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		int cnt = 0;
		parents = new int[n];
		make();
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			union(a,b);
		}
		
		for(int i=0; i<n; i++) {
			if(i == parents[i]) cnt++;
		}

		System.out.println(cnt);
		
	}

}
