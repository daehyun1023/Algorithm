package add;
import java.util.*;
public class BOJ1789수들의합 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long S = sc.nextLong();
		Long sqrtS = (Long) Math.round(Math.sqrt(S));
		Long result = (long) 0;
		for(Long i=sqrtS; i<=S; i++) {
			if( (i * (i+1)) > 2 * S) {
				result = i - 1;
				break;
			}	
		}
		System.out.println(result);
	}

}
