import java.util.*;

public class swea1288 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int n = sc.nextInt();
			int result = 0;
			boolean[] check = new boolean[10];
			while (true) {
				result += n;
				String str_n = Integer.toString(result);
				for (int i = 0; i < str_n.length(); i++) {
					int num = str_n.charAt(i) - '0';
					check[num] = true;
				}

				boolean end = true;
				for (int i = 0; i < 10; i++) {
					if (check[i] == false) {
						end = false;
						break;
					}
				}

				if (end == true) {
					break;
				}

			}
			System.out.println("#"+t+" "+result);
		}
	}

}
