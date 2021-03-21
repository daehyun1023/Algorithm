import java.util.*;
import java.io.*;
public class BOJ1759암호만들기 {

	static int L, C;
	static char[] chars, password, vowels = {'a','e','i','o','u'};
	
	public static boolean isValid() {
		int vowel = 0;
		
		for(int i=0; i<L; i++) {
			for(int j=0; j<5; j++) {
				if(password[i] == vowels[j]) {
					vowel += 1;
					break;
				}
			}
		}
		if(vowel >= 1 && L-vowel >=2) return true;
		
		return false;
	}
	
	public static void combination(int depth, int num) {
		if(depth==L) {
			if(isValid()) {
				for(int i=0; i<L; i++) {
					System.out.print(password[i]);
				}
				System.out.println();
			}
			return;
		}
		
		if(num == C) {
			return;
		}
		password[depth] = chars[num];
		combination(depth+1, num+1);
		combination(depth, num+1);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		chars = new char[C];
		password = new char[L];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<C; i++) {
			chars[i] = st.nextToken().charAt(0);
		}
		
		Arrays.sort(chars);
		combination(0,0);
		
	}

}
