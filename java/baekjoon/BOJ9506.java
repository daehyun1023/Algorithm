package add;
import java.util.*;
public class BOJ9506 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int n = sc.nextInt();
			int sum = 1;
			StringBuilder result = new StringBuilder(n+" = "+1);
			if(n == -1) {
				break;
			}
			
			for(int i=2; i<=n/2; i++) {
				if(n % i == 0) {
					result.append(" + "+i);
					sum += i;
				}
			}
			System.out.println(sum==n ? result : new String(n+" is NOT perfect."));
		}
	}

}
