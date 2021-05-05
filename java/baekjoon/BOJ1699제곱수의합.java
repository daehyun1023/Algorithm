import java.util.Scanner;

public class BOJ1699제곱수의합 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();

		int[] dp = new int[n + 1];
		dp[1] = 1;
		for (int i = 2; i < n + 1; i++) {
			dp[i] = i;
			for (int j = 1; j * j <= i; j++)
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
		}

		System.out.println(dp[n]);
	}
}