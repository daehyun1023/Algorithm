import java.util.*;
import java.io.*;

public class swea6585삼성시의버스노선 {

	static int N, A[], B[], P, result[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(br.readLine());
			A = new int[N];
			B = new int[N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				A[i] = a;
				B[i] = b;
			}
			P = Integer.parseInt(br.readLine());
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < P; i++) {
				int result = 0;
				int station = Integer.parseInt(br.readLine());
				for (int j = 0; j < N; j++) {
					if (station >= A[j] && station <= B[j]) {
						result++;
					}
				}
				sb.append(result + " ");
			}

			sb.setLength(sb.length() - 1);
			System.out.println("#"+t+" "+sb.toString());
		}
	}
}
