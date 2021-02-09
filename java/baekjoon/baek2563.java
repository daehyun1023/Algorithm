import java.util.*;

public class baekjoon2563 {

	static int N;
	static int[][] arr = new int[100][100];
	static int area = 0;

	public static void sketch(int x, int y) {
		for (int i = x; i < x + 10; i++) {
			for (int j = y; j < y + 10; j++) {
				arr[i][j] = 1;
			}
		}

	}

	public static void getArea() {
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (arr[i][j] == 1) {
					area++;
				}
			}
		}
		System.out.println(area);

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 0; i < N; i++) {
			int x = sc.nextInt() - 1;
			int y = sc.nextInt() - 1;
			sketch(x, y);
		}

		getArea();

	}

}
