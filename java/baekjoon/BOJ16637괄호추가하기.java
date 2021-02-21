import java.util.*;

public class BOJ16637괄호추가하기 {

	static int N;
	static int[] number;
	static char[] operator;
	static int operatorCnt;
	static int max = Integer.MIN_VALUE;

	public static int[] copy(int[] array) {
		int[] tmp = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			tmp[i] = array[i];
		}
		return tmp;
	}

	public static char[] copy(char[] array) {
		char[] tmp = new char[array.length];
		for (int i = 0; i < array.length; i++) {
			tmp[i] = array[i];
		}
		return tmp;
	}

	public static int calculator(int x, int y, char op) {
		if (op == '*') {
			y = y * x;
		} else if (op == '+') {
			y = y + x;
		} else {
			y = x - y;
		}
		return y;
	}

	public static void combination(int depth, int mask, int start) {
		if (depth >= 0 && depth <= (operatorCnt)/2+1) {
			int[] tempNum = copy(number);
			char[] tempOp = copy(operator);
			
			if (depth == 0) {
				for (int i = 0; i < operatorCnt; i++) {
					tempNum[i + 1] = calculator(tempNum[i], tempNum[i + 1], tempOp[i]);
				}
				max = Math.max(max, tempNum[operatorCnt]);
			} else {
				ArrayList<Integer> num = new ArrayList();
				ArrayList<Character> op = new ArrayList();
				for (int i = 0; i < operatorCnt+1; i++) {
					if ((mask & 1 << i) != 0) {
						num.add(calculator(tempNum[i], tempNum[i + 1], tempOp[i]));
						i++;
					} else {
						num.add(tempNum[i]);
					}
					if(i<operatorCnt) {						
						op.add(tempOp[i]);
					}
				}
				
				int sum = num.get(0);
				for (int i = 0; i < op.size(); i++) {
					sum = calculator(sum, num.get(i+1), op.get(i));
				}
				
				max = Math.max(sum, max);
			}
		}

		for (int i = start; i < operatorCnt; i++) {
			if ((mask & 1 << i) == 0) {
				if ((mask & 1 << (i + 1)) != 0 || (i>=1 && (mask & 1 << (i - 1)) != 0)) {
					continue;
				}
				combination(depth + 1, mask | 1 << i, i);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		number = new int[N / 2 + 1];
		operator = new char[N / 2];
		operatorCnt = N / 2;
		String str = sc.next();
		for (int i = 0; i < N; i++) {
			if (i % 2 == 1) {
				operator[i / 2] = str.charAt(i);
			} else {
				number[i / 2] = str.charAt(i) - '0';
			}
		}

		combination(0, 0, 0);
		System.out.println(max);
	}

}
