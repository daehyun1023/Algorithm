import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class swea1233 {

	static int N;
	static String[] tree;
	static boolean check = true;

	public static boolean checkOp(String value) {
		if (value.equals("+") || value.equals("*") || value.equals("/") || value.equals("-")) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) throws FileNotFoundException{
		System.setIn(new FileInputStream("input/1233.txt"));
		Scanner sc = new Scanner(System.in);
		for (int t = 0; t < 10; t++) {
			int result = 1;
			N = Integer.parseInt(sc.nextLine());
			tree = new String[N + 1];
			for (int i = 0; i < N; i++) {
				String str = sc.nextLine();
				tree[i + 1] = str.split(" ")[1];
			}
			
			
			if (N % 2 == 0)
				result = 0;

			for (int i = N; i > 1; i -= 2) {
				if (checkOp(tree[i / 2]) || !checkOp(tree[i]) && !checkOp(tree[i-1]) ) {
					tree[i / 2] = tree[i];
				} else {
					result = 0;
					break;
				}
			}

			System.out.println("#"+(t+1)+" "+result);

		}
	}

}
