package BackTracking;

import java.util.*;
import java.io.*;

public class BOJ3980선발명단 {

	static int[][] arr;
	static int[] col;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			arr = new int[11][11];
			col = new int[11];
			max = 0;
			
			for (int i = 0; i < 11; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < 11; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			back(-1, 0, 0);
			
			System.out.println(max);
		}
	}

	private static void back(int rowNo, int depth, int sum) {
		if (depth == 11) {
			max = Math.max(max, sum);
			return;
		}

		for (int i = 0; i < 11; i++) {
			if (col[i] == 0 && arr[rowNo + 1][i] != 0) {
				col[i] = arr[rowNo + 1][i];
				back(rowNo + 1, depth + 1, sum + col[i]);
				col[i] = 0;
			} else {
				continue;
			}
		}
	}
}
