import java.util.*;

public class swea1974 {

	public static boolean isLine(int[] line) {
		ArrayList<Integer> nums = new ArrayList();
		for (int i = 0; i < 9; i++) {
			if (nums.contains(line[i])) {
				return false;
			}
			nums.add(line[i]);
		}
		return true;
	}

	public static boolean isBox(int[][] box) {
		ArrayList<Integer> nums = new ArrayList();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (nums.contains(box[i][j])) {
					return false;
				}
				nums.add(box[i][j]);
			}
		}

		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int[][] arr = new int[9][9];
			int answer = 1;

			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < 9; i++) {
				int[] horizon = new int[9];
				for (int j = 0; j < 9; j++) {
					horizon[j] = arr[i][j];
				}
				if (isLine(horizon)) {
					continue;
				} else {
					answer = 0;
					break;
				}
			}

			for (int j = 0; j < 9; j++) {
				int[] vertical = new int[9];
				for (int i = 0; i < 9; i++) {
					vertical[i] = arr[i][j];
				}
				if (isLine(vertical)) {
					continue;
				} else {
					answer = 0;
					break;
				}
			}

			for (int i = 0; i < 3; i++) {
				for (int j = 0; j < 3; j++) {
					int row = i * 3;
					int col = j * 3;
					int[][] box = new int[3][3];
					for (int k = row; k < row + 3; k++) {
						for (int l = col; l < col + 3; l++) {
							box[k - row][l - col] = arr[k][l];
						}
					}

					if (isBox(box)) {
						continue;
					} else {
						answer = 0;
						break;
					}

				}
			}

			System.out.println("#" + t + " " + answer);
		}
	}

}
