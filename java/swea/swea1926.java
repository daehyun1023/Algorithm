import java.util.*;

public class swea1926 {

	static int N;

	public static int three_cnt(int num) {
		String str = Integer.toString(num);
		int cnt = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.substring(i, i + 1).equals("3") || str.substring(i, i + 1).equals("6")
					|| str.substring(i, i + 1).equals("9")) {
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			if (three_cnt(i) == 0) {
				System.out.print(i + " ");
			} else {
				for (int j = 0; j < three_cnt(i); j++) {
					System.out.print("-");
				}
				System.out.print(" ");
			}

		}

	}

}
