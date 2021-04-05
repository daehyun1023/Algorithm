import java.util.*;
import java.io.*;

public class BOJ2294동전2 {

	static int N, K, coin;
	static Set<Integer> coins = new HashSet<Integer>();
	static int[] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[100001];
		Arrays.fill(dp, 100001);
		for (int i = 0; i < N; i++) {
			coin = Integer.parseInt(br.readLine());
			coins.add(coin);
			dp[coin] = 1;
		}
		
		for(int i=1; i<=K; i++) {
			for(int coin: coins) {
				if(i <= coin) continue;
				dp[i] = Math.min(dp[i], dp[i - coin] + 1);
			}
		}
		
		System.out.println(dp[K] == 100001 ? -1 : dp[K]);
		
	}

}
