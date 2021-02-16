import java.util.*;
public class BOJ1074Z {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int leftTop = 0;
		
		while(N>0) {
			int length = (1<<N)/2;
			N -= 1;
			int small = (1<<N) * (1<<N);
			if(r >= length && c < length) {
				r -= length;
				leftTop += small*2;
			}
			else if(r < length && c >= length) {
				c -= length;
				leftTop += small;
			}
			else if(r >=length && c >= length){
				r -= length;
				c -= length;
				leftTop += small*3;
			}
		}
		
		System.out.println(leftTop);
		
	}

}
