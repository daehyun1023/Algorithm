import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16926배열돌리기1 {

	static int N;
	static int M;
	static int R;
	static int[][] arr;

	public static void subRotate(int x1, int y1, int x2, int y2) {
//		top
		int temp = arr[x1][y1];
		for (int j = y1; j < y2; j++) {
			arr[x1][j] = arr[x1][j + 1];
		}

//		right
		for (int i = x1; i < x2 ; i++) {
			arr[i][y2] = arr[i+1][y2];
			
		}

//		bottom
		for (int j = y2; j > y1; j--) {
			arr[x2][j] = arr[x2][j - 1];
		}

//		left
		for (int i = x2; i > x1; i--) {
			arr[i][y1] = arr[i - 1][y1];
		}
		arr[x1 + 1][y1] = temp;

	}

	public static void totalRotate() {
		int min = Math.min(N, M);
		for (int i = 0; i < min / 2; i++) {
			subRotate(i, i, N - 1 - i, M - 1 - i);
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		for (int i = 0; i < N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(str.nextToken());
			}
		}

		for (int i = 0; i < R; i++) {
			totalRotate();
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
