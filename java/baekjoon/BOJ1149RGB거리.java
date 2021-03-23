import java.util.*;
import java.io.*;
public class BOJ1149RGB거리 {

	static int N;
	static int[] red;
	static int[] green;
	static int[] blue;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		red = new int[N];
		green = new int[N];
		blue = new int[N];
		dp = new int[N][3];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			red[i] = Integer.parseInt(st.nextToken());
			green[i] = Integer.parseInt(st.nextToken());
			blue[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = red[0];
		dp[0][1] = green[0];
		dp[0][2] = blue[0];
		
		for(int i=1; i<N; i++) {
			dp[i][0] = Math.min(dp[i-1][1] + red[i], dp[i-1][2] + red[i]);
			dp[i][1] = Math.min(dp[i-1][0] + green[i], dp[i-1][2] + green[i]);
			dp[i][2] = Math.min(dp[i-1][0] + blue[i], dp[i-1][1] + blue[i]);
		}
		int min = Integer.MAX_VALUE;
		min = Math.min(min, dp[N-1][0]);
		min = Math.min(min, dp[N-1][1]);
		min = Math.min(min, dp[N-1][2]);
		System.out.println(min);
	}

}
