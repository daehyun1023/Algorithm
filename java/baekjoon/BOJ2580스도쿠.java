package add;

import java.util.*;
import java.io.*;

public class BOJ2580스도쿠 {

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	static int size;
	static int[][] arr = new int[9][9];
	static ArrayList<Pair> zeros = new ArrayList();
	static boolean[] check;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] == 0) {
					zeros.add(new Pair(i, j));
					size++;
				}
			}
		}

		insert(0);

	}

	private static boolean insert(int depth) {
		if (depth == size) {
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
			
			return true;
		}

		int x = zeros.get(depth).x;
		int y = zeros.get(depth).y;

		for (int i = 1; i <= 9; i++) {
			arr[x][y] = i;
			if (validWidth(x, y) && validHeight(x, y) && validSmallBox(x, y)) {
				if(insert(depth + 1)) return true;
			}
			arr[x][y] = 0;
		}
		
		return false;
		
	}

	private static boolean validSmallBox(int x, int y) {
		check = new boolean[10];
		int largeBoxX = (x / 3) * 3;
		int largeBoxY = (y / 3) * 3;
		for (int i = largeBoxX; i < largeBoxX + 3; i++) {
			for (int j = largeBoxY; j < largeBoxY + 3; j++) {
				if (check[arr[i][j]] && arr[i][j] > 0) {
					return false;
				}
				check[arr[i][j]] = true;
			}
		}
		return true;
	}

	private static boolean validHeight(int x, int y) {
		check = new boolean[10];
		for (int i = 1; i <= 9; i++) {
			if (check[arr[i - 1][y]] && arr[i - 1][y] > 0) {
				return false;
			}
			check[arr[i - 1][y]] = true;
		}
		return true;
	}

	private static boolean validWidth(int x, int y) {
		check = new boolean[10];
		for (int i = 1; i <= 9; i++) {
			if (check[arr[x][i - 1]] && arr[x][i - 1] > 0) {
				return false;
			}
			check[arr[x][i - 1]] = true;
		}
		return true;
	}

}
