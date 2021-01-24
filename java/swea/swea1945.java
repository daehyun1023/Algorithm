import java.util.*;

public class swea1945 {

	static int N;
	static int[] nums = { 2, 3, 5, 7, 11 };
	static int[] answer = new int[5];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			answer = new int[5];
			N = sc.nextInt();
			for (int i = 0; i < nums.length; i++) {
				while (N % nums[i] == 0) {
					N = N / nums[i];
					answer[i]++;
				}

			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < 5; i++) {
				System.out.print(answer[i] + " ");
			}
			System.out.println();
		}
	}
}
