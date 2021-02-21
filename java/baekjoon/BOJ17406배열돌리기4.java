import java.util.*;
import java.io.*;

public class BOJ17406배열돌리기4 {

	static int N, M, K;
	static int[][] arr, rotateInfo;
	static int[] numbers;
	static int result = Integer.MAX_VALUE;
	static int[][] temp;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][] rotate_arr;
	
	public static int[][] copy(int[][] array) {
		int[][] copy = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				copy[i][j] = array[i][j];
			}
		}
		return copy;
	}

	public static void rotate(int r, int c, int s) {
		if (s == 0) {
			return;
		}

		int currx = r - s;
		int curry = c - s;
		int nx = 0;
		int ny = 0;
		int dir = 0;

		while (true) {
			nx = currx + dx[dir];
			ny = curry + dy[dir];
			if (nx < r - s || ny < c - s || nx > r + s || ny > c + s) {
				dir = (dir + 1) % 4;
				continue;
			}

			arr[nx][ny] = rotate_arr[currx][curry];
			currx = nx;
			curry = ny;

			if (currx == r - s && curry == c - s) {
				break;
			}
		}

		rotate(r, c, s - 1);

	}

	public static void permutation(int depth, int mask) {
		if (depth == K) {
			rotate_arr = copy(temp);
			for (int i = 0; i < K; i++) {				
				rotate(rotateInfo[numbers[i]][0], rotateInfo[numbers[i]][1], rotateInfo[numbers[i]][2]);
				rotate_arr = copy(arr);
			}
			
			int min_sum = Integer.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				int row_sum = 0;
				for (int j = 0; j < M; j++) {
					row_sum += arr[i][j];
				}
				min_sum = Math.min(min_sum, row_sum);
			}

			arr = copy(temp);

			result = Math.min(min_sum, result);

			return;
		}

		for (int i = 0; i < K; i++) {
			if ((1 << i & mask) == 0) {
				numbers[depth] = i;
				permutation(depth + 1, 1 << i | mask);
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		temp = new int[N][M];
		rotateInfo = new int[K][3];
		numbers = new int[K];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				temp[i][j] = arr[i][j];
			}
		}

		for (int i = 0; i < K; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			rotateInfo[i][0] = Integer.parseInt(str.nextToken()) - 1;
			rotateInfo[i][1] = Integer.parseInt(str.nextToken()) - 1;
			rotateInfo[i][2] = Integer.parseInt(str.nextToken());
		}

		permutation(0, 0);
		System.out.println(result);

	}

}
