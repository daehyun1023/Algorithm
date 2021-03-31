import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
public class BOJ1755숫자놀이 {

	static int N, M;
	static ArrayList<String> numbers = new ArrayList();
	static HashMap<String, Integer> map = new HashMap();
	static String[] alphabet = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // 입력이 두개만 주어지므로 scanner사용
		N = sc.nextInt();
		M = sc.nextInt();
		for(int i=N; i<=M; i++) {
			String str = Integer.toString(i);
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<str.length(); j++) {	// 영어 문자열로 바꿔줌
				sb.append(alphabet[str.charAt(j) - '0']+" ");
			}
			sb.setLength(sb.length()-1);	// 맨 뒤에 공백 제거
			map.put(sb.toString(), i);		// 문자열이 어떤 숫자를 가리키는지 map에 저장
			numbers.add(sb.toString());		// 정렬하기 위해 numbers에 넣어준다.
		}
		Collections.sort(numbers);			// 문자열로 정렬해주기
		
		StringBuilder s = new StringBuilder();
		int cnt = 0;
		for (String number: numbers) {		//정렬된 문자열대로 숫자값 가져오기
			cnt++;
			s.append(map.get(number)+" ");
			if(cnt == 10) {
				s.append("\n");
				cnt = 0;
			}
		}
		
		System.out.println(s.toString());
		
	}

}

//8 9 18 15 14 19 11 17 16 13 12 10 28 25 24 21 27 26 23 22 20

// 58 55 54 51 57 56 53 52 50 48 45 44 49 41 47 46 43 42 40 38 39 37 