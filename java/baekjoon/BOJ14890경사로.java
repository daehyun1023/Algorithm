package samsung;

import java.util.*;
import java.io.*;

public class BOJ14890경사로 {

	static int N, X, result;
	static int[][] map;

	public static void check(int pivot, boolean isRow) {
		int[] temp = new int[N];
		if (isRow) {
			for (int i = 0; i < N; i++) {
				temp[i] = map[pivot][i];
			}
		} else {
			for (int i = 0; i < N; i++) {
				temp[i] = map[i][pivot];
			}
		}

		int num = temp[0];
		int cnt = 1;

		for (int i = 1; i < N; i++) {
			if (num == temp[i]) {
				cnt++;
			} else if (num + 1 == temp[i]) {
				if (cnt < X)
					return;
				num = temp[i];
				cnt = 1;
			} else if (num - 1 == temp[i]) {
				num = temp[i];
				cnt = 0;
				for (int j = i; j < i + X; j++) {
					if (j >= N || temp[j] != num)
						return;
				}
				cnt = 0;
				i += X - 1;
				continue;
			} else {
				return;
			}
		}

		result++;
		return;

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		result = 0;
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			check(i, true);
			check(i, false);
		}
		System.out.println(result);
	}

}
