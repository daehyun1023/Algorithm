import java.util.*;

public class swea10965 {

	static int N;
	static HashMap<Integer, Integer> map = new HashMap();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			ArrayList<Integer> A=new ArrayList();
			A.add(2);

			
			map.clear();
			for (int i = 2; i <= N; i++) {
				while (N > 1) {
					if (N % i == 0) {
						N = N / i;
						if (map.containsKey(i)) {
							map.replace(i, map.get(i) + 1);
						} else {
							map.put(i, 1);
						}
					}
					else {
						break;
					}
				}
			}

			int result = 1;

			for (Integer key : map.keySet()) {
				if (map.get(key) % 2 == 1) {
					result *= key;
				}
			}

			System.out.println("#" + t + " " + result);

		}
	}
}
