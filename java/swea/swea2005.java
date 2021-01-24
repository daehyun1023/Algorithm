import java.util.*;

public class swea2005 {

	static int N;
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			arr = new int[N][N];
			arr[0][0] = 1;
			for (int i = 1; i < N; i++) {
				arr[i][0] = 1;
				arr[i][i] = 1;
				for (int j = 1; j < N; j++) {
					arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
				}
			}

			System.out.println("#" + t);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (arr[i][j] == 0) {
						break;
					}
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		}

	}

}
