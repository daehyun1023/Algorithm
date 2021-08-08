import java.util.*;

public class Main {

	static int N;
	static int M;
	static int[][] arr;
	static int[][] check;
	static int area;
	static int[] dx = { 1, 1, -1, -1, 1, -1, 0, 0 };
	static int[] dy = { -1, 1, 1, -1, 0, 0, 1, -1 };

	public static void dfs(int x,int y) {
		check[x][y]=1;
		for(int i=0;i<8;i++) {
			int nx=x+dx[i];
			int ny=y+dy[i];
			if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
			if(check[nx][ny]==0 && arr[nx][ny]==1) {
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			M = sc.nextInt();
			N = sc.nextInt();
			arr = new int[N][M];
			check = new int[N][M];
			area=0;
			
			if(N==0 && M==0) {
				break;
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(check[i][j]==0 && arr[i][j]==1) {
						area++;
						dfs(i,j);
					}
				}
			}
			
			System.out.println(area);
			
		}

	}

}
