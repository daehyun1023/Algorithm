import java.util.*;
import java.io.*;
public class BOJ12865평범한배낭 {

	static int N;
	static int K;
	static int[] weight;
	static int[] value;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		weight = new int[N];
		value = new int[N];
		dp = new int[N][K+1];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());			
		}
		
		for(int i=weight[0]; i<=K; i++) {
			dp[0][i] = value[0];
		}
		
		for(int i=1; i<N; i++) {
			for(int j=0; j<=K; j++) {
				if(j < weight[i]) {
					dp[i][j] = dp[i-1][j];
					continue;
				}
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
			}
		}
		System.out.println(dp[N-1][K]);
	}

}
