import java.util.*;
import java.io.*;
public class Swea1263사람네트워크2 {
	
	static int N;
	static int[][] arr;
	static int[] check;
	static Queue<Integer> q;
	
	public static void bfs(int x) {
		q  = new LinkedList();
		q.add(x);
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i=0; i<N; i++) {
				if(check[i] == 0 && arr[cur][i] == 1) {
					check[i] = check[cur] + 1;
					q.add(i);
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int min = Integer.MAX_VALUE;
			
			for(int i=0; i<N; i++) {
				int sum = 0;
				check = new int[N];
				bfs(i);
				for(int j=0; j<N; j++) {
					if(i != j) sum+=check[j];
				}
				min = Math.min(min, sum);
			}
			
			System.out.println("#"+t+" "+min);
		}
		
	}

}
