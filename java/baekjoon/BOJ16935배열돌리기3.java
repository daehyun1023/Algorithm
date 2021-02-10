import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ16935배열돌리기3 {

	static int N;
	static int M;
	static int R;
	static int[][] arr;
	static int[][] newArr;

	public static void copy() {
		arr = new int[M][N];
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = newArr[i][j];
			}
		}
		int temp = N;
		N = M;
		M = temp;
	}

	public static void rotate(int how) {
		if (how == 1) {
			int[] temp = new int[M];
			for (int i = 0; i <= N / 2 - 1; i++) {
				for (int j = 0; j < M; j++) {
					temp[j] = arr[i][j];
					arr[i][j] = arr[N - 1 - i][j];
					arr[N - 1 - i][j] = temp[j];
				}
			}

		} else if (how == 2) {
			int[] temp = new int[N];
			for (int j = 0; j <= M / 2 - 1; j++) {
				for (int i = 0; i < N; i++) {
					temp[i] = arr[i][j];
					arr[i][j] = arr[i][M - 1 - j];
					arr[i][M - 1 - j] = temp[i];
				}
			}

		} else if (how == 3) {
			newArr = new int[M][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newArr[j][N - 1 - i] = arr[i][j];
				}
			}

			copy();
			
		} else if (how == 4) {
			newArr = new int[M][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					newArr[M - 1 -j][i] = arr[i][j];
				}
			}

			copy();
			
		} else if (how == 5) {
			int[][] temp = new int[N][M];
			for(int i=0; i<N/2; i++) {
				for(int j=0; j<M/2; j++) {
					temp[i][j] = arr[i][j];
					arr[i][j] = arr[i+N/2][j];
					arr[i+N/2][j] = arr[i+N/2][j+M/2];
					arr[i+N/2][j+M/2] = arr[i][j+M/2];
					arr[i][j+M/2] = temp[i][j];
				}
			}
			
		} else {
			int[][] temp = new int[N][M];
			for(int i=0; i<N/2;i++) {
				for(int j=0; j<M/2;j++) {
					temp[i][j] = arr[i][j];
					arr[i][j] = arr[i][j+M/2];
					arr[i][j+M/2] = arr[i+N/2][j+M/2];
					arr[i+N/2][j+M/2] = arr[i+N/2][j];
					arr[i+N/2][j] = temp[i][j];
				}
			}
			
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

		StringTokenizer str = new StringTokenizer(br.readLine());

		for (int i = 0; i < R; i++) {
			int how = Integer.parseInt(str.nextToken());
			rotate(how);
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}

}
