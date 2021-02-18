import java.util.*;
import java.io.*;

public class BOJ3109빵집 {

	static int R, C, cnt;
	static char[][] arr;
	static int[] dx = { -1, 0, 1 };
	static boolean[][] check;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[R][];
		check = new boolean[R][C];
		for (int i = 0; i < R; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		
		makePipe();
		System.out.println(cnt);
	}

	private static void makePipe() {
		// 윗행부터 시도
		for (int i=0; i<R; i++) {
			check[i][0] = true;
			dfs(i,0);
		}
		
	}

	private static boolean dfs(int x, int y) {
		if(y == C-1) {
			cnt++;
			return true;
		}
		
		int nx, ny = y+1;
		for (int d = 0; d < 3; d++) {
			nx = x + dx[d];
			if(nx < 0 || nx >= R || arr[nx][ny]=='x' || check[nx][ny]==true) continue;
			check[nx][ny] = true;
			if(dfs(nx, ny)) return true;
		}
		
		return false;
	}
	
}
