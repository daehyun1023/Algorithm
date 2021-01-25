import java.util.*;
public class swea11285 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		for(int i=0; i<n; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			float c = (float) Math.pow((a*a + b*b),0.5);
			for(int j=1; j<=10;j++) {
				if(c<20*j) {
					result += 11-j;
					break;
				}
			}
			
		}
		System.out.println(result);
	}

}
