import java.util.*;
import java.io.*;

public class Algo2_서울_13반_안대현 {

	static int N, M, circle;
	static int[] chus;
	static boolean[] dp;
	static StringBuilder sb = new StringBuilder();

	public static void find() {
		// N이 최대 30이므로 조합으로 풀게된다면 시간초과가 날 것임
		// 따라서 dp로 풀어야 한다고 생각
		dp[0] = true;
		ArrayList<Integer> temp = new ArrayList(); // 양옆의 합과 차이를 고려해서 temp arraylist에 저장해준다.
		for (int i = 0; i < N; i++) {
			temp = new ArrayList();
			int now = chus[i];
			for(int j=0; j<=40000; j++) {
				if(dp[j] == true) {
					if(j + now <= 40000) {						
						temp.add(j+now);
					}
					if(j - now > 0) {						
						temp.add(j-now);
					}
					if(now - j > 0) {						
						temp.add(now-j);
					}
				}
			}
			for(Integer num: temp) {
				dp[num] = true;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		chus = new int[N];
		dp = new boolean[40001];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			chus[i] = Integer.parseInt(st.nextToken());
		}

		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		find();
		for (int i = 0; i < M; i++) {
			circle = Integer.parseInt(st.nextToken());
			if (dp[circle]) {
				sb.append("Y ");
			} else {
				sb.append("N ");
			}
		}

		sb.setLength(sb.length() - 1);
		System.out.println(sb.toString());
	}
}
