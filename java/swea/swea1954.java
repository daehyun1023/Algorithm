import java.util.*;

public class swea1954 {

	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N;
	static int[][] arr;

	public static void solve(int x, int y, int d, int num) {
		arr[x][y] = num;

		if (num == Math.pow(N, 2)) {
			return;
		}

		int nx = x + dx[d];
		int ny = y + dy[d];

		if (nx >= 0 && ny >= 0 && nx < N && ny < N && arr[nx][ny] == 0) {
			arr[nx][ny] = num + 1;
			solve(nx, ny, d, num + 1);
		}

		else {
			solve(x, y, (d + 1) % 4, num);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			solve(0, 0, 0, 1);
			
			System.out.println("#"+t);
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
