import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ1700멀티탭스케줄링 {

	static int N;
	static int K;
	static int[] machine;
	static ArrayList<Integer> tab = new ArrayList();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		machine = new int[K];
		for (int i = 0; i < K; i++) {
			machine[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < K; i++) {
			if (tab.size() != N) {
				tab.add(machine[i]);
			} else {
				ArrayList<Integer> reuse = new ArrayList();
				for (int j = i + 1; j < K; j++) {
					if(!tab.contains(machine[j])) {
						
					}
				}
			}

		}

	}

}
