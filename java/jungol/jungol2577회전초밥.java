import java.util.*;
import java.io.*;

public class jungol2577회전초밥 {

	static int N, d, k, c, max;
	static int[] src;
	static int[] select = new int[3001]; // 1부터 시작

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		src = new int[N];

		for (int i = 0; i < N; i++) {
			src[i] = Integer.parseInt(br.readLine());
		}

		select[c] = 1;
		int kind = 1;
		// 처음 k개 처리
		for (int i = 0; i < k; i++) {
			if (select[src[i]]++ == 0)
				kind++;
		}
		max = kind;

		for (int i = k; i < N + k - 1; i++) {
			// 맨앞 접시 제거
			int dish = src[i-k];
			if(--select[dish] == 0) kind--;
			//뒤 접시 추가
			if(i < N) {
				dish = src[i];
			} else {
				dish = src[i-N];
			}
			if(select[dish]++ == 0) kind++;
			
			max = Math.max(max, kind);
		}
		System.out.println(max);
	}

}
