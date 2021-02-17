import java.util.*;
import java.io.*;
public class BOJ17070파이프옮기기1 {

	static int N;
	static int[][] arr;
	static int result = 0;
	
	public static void solve(int x, int y, int d) {
		// d는 현재 방향:  0이면 가로방향, 1이면 세로방향, 2이면 대각선방향
		if(x>=N || y>=N || arr[x][y]==1) return;
		
		if(d==2 && (arr[x-1][y] == 1 || arr[x][y-1] == 1)) return;
		
		if(x==N-1 && y==N-1) {
			result++;
			return;
		}
		
		solve(x+1, y+1, 2);
		if(d==0 || d==2) solve(x, y+1, 0);
		if(d==1 || d==2) solve(x+1, y, 1);
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(0,1,0);
		System.out.println(result);
	}

}
