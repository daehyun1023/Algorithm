import java.util.*;
import java.io.*;

public class BOJ17281야구 {

	static int N;
	static int[][] arr;
	static int[] numbers = new int[8];
	static int[] player = new int[9];
	static boolean[] check = new boolean[8];
	static int result = Integer.MIN_VALUE;
	static int cnt = 0;

	public static void solve(int depth) {
		if (depth == 8) {
			for(int i=0; i<9; i++) {
				if(i==3) continue;
				if(i<3) {
					player[i] = numbers[i];
				}
				else {
					player[i] = numbers[i-1];
				}
			}
			play();
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (check[i] == false) {
				check[i] = true;
				numbers[depth] = i + 2;
				solve(depth + 1);
				check[i] = false;
			}

		}
	}

	public static void play() {
		int idx = 8;
		int score = 0;
		for (int i = 0; i < N; i++) {
			int out = 0;
			boolean[] runner = new boolean[4];
			while (true) {
				idx = (idx + 1) % 9;
				if (arr[i][player[idx] - 1] == 0) {
					out++;
					if (out == 3) {
						break;
					}
					continue;
				}
				for (int j = 3; j >= 0; j--) {
					if (j > 0 && runner[j] == false)
						continue;
					runner[j] = false;
					if (j + arr[i][player[idx] - 1] >= 4) {
						score++;
					} else {
						runner[j + arr[i][player[idx] - 1]] = true;
					}
				}
			}
		}

		result = Math.max(result, score);

	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][9];
		player[3] = 1;
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		solve(0);
		play();
		System.out.println(result);

	}

}
