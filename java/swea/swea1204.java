import java.util.*;
public class swea1204 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=0;t<T;t++) {
			int n = sc.nextInt();
			int result = 0;
			int[] arr = new int[101];
			for(int i=0; i<1000;i++) {
				int score=sc.nextInt();
				arr[score]+=1;
			}
			
			int max = 0;
			for(int i=0;i<101;i++) {
				if(max <= arr[i]) {
					max= arr[i];
					result = i;
				}
			}
			
			
			System.out.println("#"+n+" "+result);
			
		}
		
	}

}
