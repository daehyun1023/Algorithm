import java.util.*;
import java.io.*;

public class BOJ2961도영이맛있는음식 {

	static int[] sour; // 신맛
	static int[] bitterness; // 쓴맛
	static int result = Integer.MAX_VALUE;
	static int N;
	
	public static void combination(int depth, int mask, int x) {
		if (depth >=1 && depth <=N) {
			int mulSour = 1;
			int sumBitterness = 0;
			for (int i = 0; i < N; i++) {
				if ((mask & 1 << i) != 0) {
					mulSour *= sour[i];
					sumBitterness += bitterness[i];
				}
			}
			result = Math.min(result, Math.abs(mulSour - sumBitterness));
			
			if(depth == N) {
				return;
			}
		}

		for (int i = x; i < N; i++) {
			if ((mask & 1 << i) == 0) {
				combination(depth + 1, mask | 1 << i, i);
			}
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		sour = new int[N];
		bitterness = new int[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sour[i] = Integer.parseInt(st.nextToken());
			bitterness[i] = Integer.parseInt(st.nextToken());
		}

		combination(0, 0, 0);

		System.out.println(result);
	}

}
