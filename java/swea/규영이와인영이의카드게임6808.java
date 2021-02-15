import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 규영이와인영이의카드게임6808 {

	static ArrayList<Integer> input = new ArrayList();
	static int[] arr = new int[9];
	static boolean[] check = new boolean[9];
	static int win;
	static int lose;
	static int[] numbers = new int[9];

	public static void permutation(int depth) {
		if (depth == 9) {
			int gyu = 0;
			for (int i = 0; i < 9; i++) {
				if (input.get(i) > numbers[i]) {
					gyu += input.get(i) + numbers[i];
				} else if (input.get(i) < numbers[i]) {
					gyu -= input.get(i) + numbers[i];
				}
			}
			if (gyu > 0) {
				win++;
			} else {
				lose++;
			}

			return;
		}

		for (int i = 0; i < 9; i++) {
			if (check[i] == false) {
				check[i] = true;
				numbers[depth] = arr[i];
				permutation(depth + 1);
				check[i] = false;
			}
		}

	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			win = 0;
			lose = 0;
			input.clear();
			Arrays.fill(check, false);
			Arrays.fill(arr, 0);
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 9; i++) {
				input.add(Integer.parseInt(st.nextToken()));
			}

			int idx = 0;
			for (int i = 1; i <= 18; i++) {
				if (!input.contains(i)) {
					arr[idx++] = i;
				}
			}

			permutation(0);
			System.out.println("#"+t+" "+win + " " + lose);
		}
	}

}
